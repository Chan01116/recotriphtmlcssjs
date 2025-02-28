package com.letsgotravle.myapp.api;
/**
 * <pre>
 * io.codef.easycodef
 *   |_ EasyCodefProperties.java
 * </pre>
 * 
 * Desc : μ½λ??? ?¬?΄ ?¬?©? ?? ?λ‘νΌ?° ?΄??€ 
 * @Company : Β©CODEF corp.
 * @Author  : notfound404@codef.io
 * @Date    : Jun 26, 2020 3:36:51 PM
 */
public class EasyCodefProperties {
	
	//	?°λͺ? ??Έ?€ ? ?° λ°κΈ? ?? ?΄?Ό?΄?Έ?Έ ??΄?
	private String demoClientId 	= "";
	
	//	?°λͺ? ??Έ?€ ? ?° λ°κΈ? ?? ?΄?Ό?΄?Έ?Έ ??¬λ¦?
	private String demoClientSecret 	= "";	
	
	//	OAUTH2.0 ?°λͺ? ? ?°
	private String demoAccessToken = "";
	
	//	? ? ??Έ?€ ? ?° λ°κΈ? ?? ?΄?Ό?΄?Έ?Έ ??΄?
	private String clientId 	= "";
	
	//	? ? ??Έ?€ ? ?° λ°κΈ? ?? ?΄?Ό?΄?Έ?Έ ??¬λ¦?
	private String clientSecret 	= "";	
	
	//	OAUTH2.0 ? ?°
	private String accessToken = "";
	
	//	RSA??Έ?λ₯? ?? ?ΌλΈλ¦­?€
	private String publicKey 	= "";

	
	/**
	 * Desc : ? ??λ²? ?¬?©? ?? ?΄?Ό?΄?Έ?Έ ? λ³? ?€? 
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:02 PM
	 * @param clientId
	 * @param clientSecret
	 */
	public void setClientInfo(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	/**
	 * Desc : ?°λͺ¨μλ²? ?¬?©? ?? ?΄?Ό?΄?Έ?Έ ? λ³? ?€? 
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:10 PM
	 * @param demoClientId
	 * @param demoClientSecret
	 */
	public void setClientInfoForDemo(String demoClientId, String demoClientSecret) {
		this.demoClientId = demoClientId;
		this.demoClientSecret = demoClientSecret;
	}
	
	/**
	 * Desc : ?°λͺ? ?΄?Ό?΄?Έ?Έ ??΄? λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:17 PM
	 * @return
	 */
	public String getDemoClientId() {
		return demoClientId;
	}

	/**
	 * Desc : ?°λͺ? ?΄?Ό?΄?Έ?Έ ??¬λ¦? λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:23 PM
	 * @return
	 */
	public String getDemoClientSecret() {
		return demoClientSecret;
	}

	/**
	 * Desc : ?°λͺ? ? ? ? ?° λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:30 PM
	 * @return
	 */
	public String getDemoAccessToken() {
		return demoAccessToken;
	}

	/**
	 * Desc : ?°λͺ? ?΄?Ό?΄?Έ?Έ ??¬λ¦? λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:36 PM
	 * @Version : 1.0.1
	 * @return
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Desc : API ?΄?Ό?΄?Έ?Έ ??¬λ¦? λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:44 PM
	 * @return
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * Desc : API ? ? ? ?° λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:50 PM
	 * @Version : 1.0.1
	 * @return
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Desc : RSA??Έ?λ₯? ?? ?ΌλΈλ¦­?€ λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:37:59 PM
	 * @return
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * Desc : RSA??Έ?λ₯? ?? ?ΌλΈλ¦­?€ ?€? 
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:38:07 PM
	 * @Version : 1.0.1
	 * @param publicKey
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * Desc : ?°λͺ? ? ? ? ?° ?€? 
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:38:14 PM
	 * @param demoAccessToken
	 */
	public void setDemoAccessToken(String demoAccessToken) {
		this.demoAccessToken = demoAccessToken;
	}

	/**
	 * Desc : API ? ? ? ?° ?€? 
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:38:21 PM
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
}