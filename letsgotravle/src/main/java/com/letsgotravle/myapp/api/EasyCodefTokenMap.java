package com.letsgotravle.myapp.api;

import java.util.HashMap;

/**
 * <pre>
 * io.codef.easycodef
 *   |_ EasyCodefTokenMap.java
 * </pre>
 * 
 * Desc : ?¬?΄ μ½λ?? ?΄?©? ?? ? ?° κ΄?λ¦? ?΄??€
 * @Company : Β©CODEF corp.
 * @Author  : notfound404@codef.io
 * @Date    : Jun 26, 2020 3:41:13 PM
 */
public class EasyCodefTokenMap {
	
	/**	?¬?΄ μ½λ?? ?΄?©? ?? ? ?° ???₯ λ§?	*/
	private static HashMap<String, String> ACCESS_TOKEN_MAP = new HashMap<String, String>();
	
	/**
	 * Desc : ? ?° ???₯ 
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:41:21 PM
	 * @param clientId
	 * @param accessToken
	 */
	public static void setToken(String clientId, String accessToken) {
		ACCESS_TOKEN_MAP.put(clientId, accessToken);
	}
	
	/**
	 * Desc : ? ?° λ°ν
	 * @Company : Β©CODEF corp.
	 * @Author  : notfound404@codef.io
	 * @Date    : Jun 26, 2020 3:41:28 PM
	 * @param clientId
	 * @return
	 */
	public static String getToken(String clientId) {
		return ACCESS_TOKEN_MAP.get(clientId);
	}
}
