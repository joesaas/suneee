/**  
 * File Name:IAuthentication.java  
 * Package Name:com.suneee.core.shiro.authc  
 * Description: (That's the purpose of the file)
 * Date:2014年12月4日下午2:48:55  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.shiro.authc;  

import java.util.Map;

/**  
 * ClassName:IAuthentication <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月4日 下午2:48:55 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface IAuthenticator
{
	/**
	 * 认证者处理认证信息
	 * @Title: handleAuthc 
	 * @Description: (That's the purpose of the method) 
	 * @param params
	 * @return
	 * @throws
	 */
	public  boolean  handleAuthc(Map<String, String> params);
	
}
  
