package com.letsgotravle.myapp.api;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * io.codef.easycodef
 *   |_ EasyCodefUtil.java
 * </pre>
 * 
 * Desc : ?¬?΄ μ½λ?? ? ?Έ ?΄??€
 * @Company : Β©CODEF corp.
 * @Author  : notfound404@codef.io
 * @Date    : Jun 26, 2020 3:41:39 PM
 */
public class EasyCodefUtil {

	/**
	 * Desc : RSA??Έ?
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:41:50 PM
	 * @param plainText
	 * @param publicKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static String encryptRSA(String plainText, String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] bytePublicKey = Base64.getDecoder().decode(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey key = keyFactory.generatePublic(new X509EncodedKeySpec(bytePublicKey));
		
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] bytePlain = cipher.doFinal(plainText.getBytes());
		String encrypted = Base64.getEncoder().encodeToString(bytePlain);
	
		return encrypted;
	}
	
	/**
	 * Desc : byteλ°°μ΄λ‘? μΆμΆ? ??Ό ? λ³΄λ?? BASE64 λ¬Έμ?΄λ‘? ?Έμ½λ©
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:41:58 PM
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String encodeToFileString(String filePath) throws IOException {
		File file = new File(filePath);
		
		byte[] fileContent = FileUtils.readFileToByteArray(file);
		String fileString = Base64.getEncoder().encodeToString(fileContent);
		
		return fileString;
	}
	
	/**
	 * ? ?° λ§? λ³??
	 * 
	 * @param request
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> getTokenMap(String token) throws JsonParseException, JsonMappingException, IOException {

		/** ?΄?Ό?΄?Έ?Έ ?λ³? κ°?, ?μ²? ?λ³? κ°? μΆμΆ? ?? ?μ½λ */
		String[] split_string = token.split("\\.");
		String base64EncodedBody = split_string[1];
		String tokenBody = new String(Base64.getDecoder().decode(base64EncodedBody));

		/** λ§? λ³?? */
		return new ObjectMapper().readValue(tokenBody, HashMap.class);
	}
	
	/**
	 * Comment  : ?μ²? ? ?° ? ?©?± μ²΄ν¬
	 * @version : 1.0.1
	 * @tags    : @param headerMap
	 * @tags    : @return
	 * @date    : Jun 24, 2020
	 */
	public static boolean checkValidity(int expInt) {
		long now = new Date().getTime();
		String expStr = expInt + "000";	// ??¬ ?κ°? ????€?¬??? ?λ¦¬μ λ§μΆκΈ?(13?λ¦?)
		long exp  = Long.parseLong(expStr);
		if(now > exp || (exp - now < 3600000)) { // ? ?¨κΈ°κ° ??Έ::? ?¨κΈ°κ°?΄ μ§??¬κ±°λ ??κ°? ?΄?΄λ‘? λ§λ£?? κ²½μ°
			return false;
		}
		
		return true;
	}
}