package com.letsgotravle.myapp.api;

/**
 * <pre>
 * io.codef.easycodef
 *   |_ EasyCodefConstant.java
 * </pre>
 * 
 * Desc : EasyCodefλ₯? ?¬?©?κΈ? ??΄ ??? ?? ?μ²? κ΄?? ¨ ? λ³? ?΄??€
 * @Company : Β©CODEF corp.
 * @Author  : notfound404@codef.io
 * @Date    : Jun 26, 2020 3:36:32 PM
 */
public class EasyCodefConstant {
	
	/**	OAUTH ?λ²? ?λ©μΈ	*/
	protected static final String OAUTH_DOMAIN = "https://oauth.codef.io";
	
	/**	OAUTH ??Έ?€ ? ?° λ°κΈ URL PATH	*/
	protected static final String GET_TOKEN = "/oauth/token";
	
	
	/**	??λ°μ€ ?λ²? ?λ©μΈ	*/
	protected static final String SANDBOX_DOMAIN = "https://sandbox.codef.io";
	
	/**	??λ°μ€ ??Έ?€ ? ?° λ°κΈ? ?? ?΄?Ό?΄?Έ?Έ ??΄?	*/
	protected static final String SANDBOX_CLIENT_ID 	= "ef27cfaa-10c1-4470-adac-60ba476273f9";
	
	/**	??λ°μ€ ??Έ?€ ? ?° λ°κΈ? ?? ?΄?Ό?΄?Έ?Έ ??¬λ¦?	*/
	protected static final String SANDBOX_CLIENT_SECRET 	= "83160c33-9045-4915-86d8-809473cdf5c3";
	
	
	/**	?°λͺ? ?λ²? ?λ©μΈ	*/
	protected static final String DEMO_DOMAIN = "https://development.codef.io";
	
	/**	? ? ?λ²? ?λ©μΈ	*/
	protected static final String API_DOMAIN = "https://api.codef.io";
	
	
	/** ??΅λΆ? ?? κ²°κ³Ό ?€??	*/
	protected static final String RESULT = "result";
	
	/** ??΅λΆ? ?? κ²°κ³Ό λ©μμ§? μ½λ ?€??	*/
	protected static final String CODE = "code";

	/** ??΅λΆ? ?? κ²°κ³Ό λ©μμ§? ?€??	*/
	protected static final String MESSAGE = "message";
	
	/** ??΅λΆ? ?? κ²°κ³Ό μΆκ? λ©μμ§? ?€??	*/
	protected static final String EXTRA_MESSAGE = "extraMessage";
	
	/**	??΅λΆ? ?? κ²°κ³Ό ?°?΄?° ?€??	*/
	protected static final String DATA = "data";
	
	/** κ³μ  λͺ©λ‘  ?€??	*/
	protected static final String ACCOUNT_LIST = "accountList";
	
	protected static final String CONNECTED_ID = "connectedId";
	
	
	/**	??Έ?€ ? ?° κ±°μ  ?¬? 1	*/
	protected static String INVALID_TOKEN = "invalid_token";
	
	/**	??Έ?€ ? ?° κ±°μ  ?¬? 2	*/
	protected static String ACCESS_DENIED = "access_denied";
	
	/**	κ³μ  ?±λ‘? URL	*/
	protected static final String CREATE_ACCOUNT = "/v1/account/create";
	
	/**	κ³μ  μΆκ? URL	*/
	protected static final String ADD_ACCOUNT = "/v1/account/add";
	
	/**	κ³μ  ??  URL	*/
	protected static final String UPDATE_ACCOUNT = "/v1/account/update";
	
	/**	κ³μ  ?­?  URL	*/
	protected static final String DELETE_ACCOUNT = "/v1/account/delete";
	
	/**	κ³μ  λͺ©λ‘ μ‘°ν URL	*/
	protected static final String GET_ACCOUNT_LIST = "/v1/account/list";
	
	/**	μ»€λ₯?°? ??΄? λͺ©λ‘ μ‘°ν URL	*/
	protected static final String GET_CID_LIST = "/v1/account/connectedId-list"; 
	
}