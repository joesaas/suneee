/**  
 * File Name:LoginAuthorizationFilter.java  
 * Package Name:com.suneee.core.shiro.filter  
 * Description: (That's the purpose of the file)
 * Date:2014年12月4日下午2:20:45  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.shiro.filter;  

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import com.suneee.core.common.constant.Global;
import com.suneee.core.shiro.authc.IAuthenticator;

/**  
 * ClassName:LoginAuthorizationFilter <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月4日 下午2:20:45 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class LoginAuthorizationFilter extends AuthorizationFilter
{
	private IAuthenticator authenticator;
	
	/**
	 * 验证用户登录信息
	 * TODO  
	 * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)
	 */
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
	        throws Exception
	{
		if(authenticator == null){
			return false;
		}
		Map<String, String> params = new  HashMap<String, String>();
		
		params.put(Global.USER_NAME, request.getParameter(Global.USER_NAME));
		params.put(Global.PASSWORD, request.getParameter(Global.PASSWORD));
		
		return authenticator.handleAuthc(params);
	}

	
	public IAuthenticator getAuthenticator()
	{
		return authenticator;
	}

	public void setAuthenticator(IAuthenticator authenticator)
	{
		this.authenticator = authenticator;
	}

}
  
