package com.letsgotravle.myapp.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * io.codef.easycodef
 *   |_ EasyCodefConnector.java
 * </pre>
 * 
 * Desc : CODEF ??Έ?€ ? ?° λ°? ?? μ‘°νλ₯? ?? HTTP ?μ²? ?΄??€
 * @Company : Β©CODEF corp.
 * @Author  : notfound404@codef.io
 * @Date    : Jun 26, 2020 3:35:17 PM
 */
public class EasyCodefConnector {
	private static ObjectMapper mapper = new ObjectMapper();
	private static final int REPEAT_COUNT = 3;
	
	/**
	 * Desc : CODEF ?? μ‘°ν ?μ²?
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:35:26 PM
	 * @param urlPath
	 * @param serviceType
	 * @param bodyMap
	 * @param properties
	 * @return
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	protected static EasyCodefResponse execute(String urlPath, int serviceType, HashMap<String, Object> bodyMap, EasyCodefProperties properties) throws InterruptedException {
		/**	#1.? ?° μ²΄ν¬	*/
		String domain;
		String clientId;
		String clientSecret;

		if(serviceType == 0) {
			domain = EasyCodefConstant.API_DOMAIN;
			clientId = properties.getClientId();
			clientSecret = properties.getClientSecret();
		} else if(serviceType == 1) {
			domain = EasyCodefConstant.DEMO_DOMAIN;
			clientId = properties.getDemoClientId();
			clientSecret = properties.getDemoClientSecret();
		} else {
			domain = EasyCodefConstant.SANDBOX_DOMAIN;
			clientId = EasyCodefConstant.SANDBOX_CLIENT_ID;
			clientSecret = EasyCodefConstant.SANDBOX_CLIENT_SECRET;
		}
		
		String accessToken = getToken(clientId, clientSecret); // ? ?° λ°ν
		
		/**	#2.?μ²? ??Όλ―Έν° ?Έμ½λ©	*/
		String bodyString;
		try {
			bodyString = mapper.writeValueAsString(bodyMap);
			bodyString = URLEncoder.encode(bodyString, "UTF-8");
		} catch (JsonProcessingException e) {
			EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.INVALID_JSON); 
			return response;
		} catch (UnsupportedEncodingException e) {
			EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.UNSUPPORTED_ENCODING); 
			return response;
		}
		
		/**	#3.?? μ‘°ν ?μ²?	*/
		HashMap<String, Object> responseMap = requestProduct(domain + urlPath, accessToken, bodyString);
		if(EasyCodefConstant.INVALID_TOKEN.equals(responseMap.get("error")) || "CF-00401".equals(((HashMap<String, Object>)responseMap.get(EasyCodefConstant.RESULT)).get(EasyCodefConstant.CODE))){	// ?‘?Έ?€ ? ?° ? ?¨κΈ°κ° λ§λ£??? κ²½μ° ? ?° ?¬λ°κΈ ? ?? μ‘°ν ?μ²? μ§ν
			EasyCodefTokenMap.setToken(clientId, null);		// ? ?° ? λ³? μ΄κΈ°?
			accessToken = getToken(clientId, clientSecret); // ? ?° ?€? 
			responseMap = requestProduct(domain + urlPath, accessToken, bodyString);
		} else if (EasyCodefConstant.ACCESS_DENIED.equals(responseMap.get("error")) || "CF-00403".equals(((HashMap<String, Object>)responseMap.get(EasyCodefConstant.RESULT)).get(EasyCodefConstant.CODE))) {	// ? κ·? κΆν?΄ ?? κ²½μ° - ?€λ₯μ½? λ°ν
			EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.UNAUTHORIZED, EasyCodefConstant.ACCESS_DENIED); 
			return response;
		}
		
		/**	#4.?? μ‘°ν κ²°κ³Ό λ°ν	*/
		EasyCodefResponse response = new EasyCodefResponse(responseMap); 
		return response;
	}
	
	/**
	 * Desc : CODEF HTTP POST ?μ²?
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:35:34 PM
	 * @param urlPath
	 * @param token
	 * @param bodyString
	 * @return
	 */

	    // κΈ°μ‘΄ requestProduct λ©μ? (private ? μ§?)
	    private static HashMap<String, Object> requestProduct(String urlPath, String token, String bodyString) {
	        BufferedReader br = null;
	        try {
	            // HTTP ?μ²?? ?? URL ?€λΈμ ?Έ ??±
	            URL url = new URL(urlPath);
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	            con.setDoOutput(true);
	            con.setRequestMethod("POST");
	            con.setRequestProperty("Accept", "application/json");

	            if (token != null && !"".equals(token)) {
	                con.setRequestProperty("Authorization", "Bearer " + token); // ??Έ?€ ? ?° ?€? ?€? 
	            }

	            // λ¦¬ν?μ€?Έ λ°λ ? ?‘
	            OutputStream os = con.getOutputStream();
	            if (bodyString != null && !"".equals(bodyString)) {
	                os.write(bodyString.getBytes());
	            }
	            os.flush();
	            os.close();

	            // ??΅ μ½λ ??Έ
	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                br = new BufferedReader(new InputStreamReader(con.getInputStream())); 
	            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
	                EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.BAD_REQUEST, urlPath); 
	                return response;
	            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
	                EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.UNAUTHORIZED, urlPath); 
	                return response; 
	            } else if (responseCode == HttpURLConnection.HTTP_FORBIDDEN) {
	                EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.FORBIDDEN, urlPath); 
	                return response; 
	            } else if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
	                EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.NOT_FOUND, urlPath); 
	                return response; 
	            } else {
	                EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.SERVER_ERROR, urlPath); 
	                return response;
	            }

	            // ??΅ λ°λ read
	            String inputLine;
	            StringBuffer responseStr = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                responseStr.append(inputLine);
	            }
	            br.close();

	            // κ²°κ³Ό λ°ν
	            return mapper.readValue(URLDecoder.decode(responseStr.toString(), "UTF-8"), new TypeReference<HashMap<String, Object>>() {});
	        } catch (Exception e) {
	            EasyCodefResponse response = new EasyCodefResponse(EasyCodefMessageConstant.LIBRARY_SENDER_ERROR, e.getMessage()); 
	            return response;
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {}
	            }
	        }
	    }

	    // Getter λ©μ? μΆκ?
	    public static HashMap<String, Object> getRequestProduct(String urlPath, String token, String bodyString) {
	        return requestProduct(urlPath, token, bodyString);
	    }

	
	/**
	 * Desc : ??Έ?€ ? ?° λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:35:47 PM
	 * @param clientId
	 * @param clientSecret
	 * @return
	 * @throws InterruptedException
	 */
	private static String getToken(String clientId, String clientSecret) throws InterruptedException {
		int i = 0;
		String accessToken = EasyCodefTokenMap.getToken(clientId);
		if(accessToken == null || "".equals(accessToken) || !checkToken(accessToken)) { //λ§λ£ μ‘°κ±΄ μΆκ?
			while(i < REPEAT_COUNT) {	// ? ?° λ°κΈ ?μ²??? μ΅λ? 3?κΉμ? ?¬??
				HashMap<String, Object> tokenMap = publishToken(clientId, clientSecret);	// ? ?° λ°κΈ ?μ²?
				if(tokenMap != null) {
					String newToken = (String)tokenMap.get("access_token");
					EasyCodefTokenMap.setToken(clientId, newToken);	// ? ?° ???₯
					accessToken = newToken;
				}
				
				if(accessToken != null || !"".equals(accessToken)) {
					break;	// ? ? λ°κΈ? λ°λ³΅λ¬? μ’λ£
				}
				
				Thread.sleep(20);
				i++;
			}
		}
		
		return accessToken;
	}
	
	/**
	 * Desc : CODEF ??Έ?€ ? ?° λ°κΈ ?μ²?
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:36:01 PM
	 * @param clientId
	 * @param clientSecret
	 * @return
	 */
	protected static HashMap<String, Object> publishToken(String clientId, String clientSecret) {
		BufferedReader br = null;
		try {
			// HTTP ?μ²?? ?? URL ?€λΈμ ?Έ ??±
			URL url = new URL(EasyCodefConstant.OAUTH_DOMAIN + EasyCodefConstant.GET_TOKEN);
			String params = "grant_type=client_credentials&scope=read";	// Oauth2.0 ?¬?©? ?κ²©μ¦λͺ? λ°©μ(client_credentials) ? ?° ?μ²? ?€? 
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			// ?΄?Ό?΄?Έ?Έ??΄?, ??¬λ¦Ώμ½? Base64 ?Έμ½λ©
			String auth = clientId + ":" + clientSecret;
			byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
			String authStringEnc = new String(authEncBytes);
			String authHeader = "Basic " + authStringEnc;
			
			con.setRequestProperty("Authorization", authHeader);
			con.setDoInput(true);
			con.setDoOutput(true);
			
			// λ¦¬ν?μ€?Έ λ°λ ? ?‘
			OutputStream os = con.getOutputStream();
			os.write(params.getBytes());
			os.flush();
			os.close();
	
			// ??΅ μ½λ ??Έ
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {	// ? ? ??΅
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {	 // ??¬ λ°μ
				return null;
			}
			
			// ??΅ λ°λ read
			String inputLine;
			StringBuffer responseStr = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				responseStr.append(inputLine);
			}
			br.close();
			
			HashMap<String, Object> tokenMap = mapper.readValue(URLDecoder.decode(responseStr.toString(), "UTF-8"), new TypeReference<HashMap<String, Object>>(){});
			return tokenMap;
		} catch (Exception e) {
			return null;
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) { }
			}
		}
	}

	/**
	 * ? ?° ? ?¨κΈ°κ° ??Έ
	 * @param accessToken
	 * @return
	 */
	private static boolean checkToken(String accessToken) {
        HashMap<String, Object> tokenMap = null;
        try {
            tokenMap = EasyCodefUtil.getTokenMap(accessToken);
        } catch (IOException e) {
            // ??Έ μ€? ?€λ₯? λ°μ ?
            return false;
        }
        // ? ?°? ? ?¨ κΈ°κ° ??Έ
        return EasyCodefUtil.checkValidity((int) (tokenMap.get("exp")));
    }
}