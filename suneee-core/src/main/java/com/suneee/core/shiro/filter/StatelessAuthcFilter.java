/**  
 * File Name:StatelessAuthcFilter.java  
 * Package Name:com.suneee.core.shiro.realm  
 * Description: (That's the purpose of the file)
 * Date:2014年11月28日上午10:18:45  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.shiro.filter;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suneee.core.common.constant.Global;
import com.suneee.core.shiro.token.StatelessToken;

/**  
 * ClassName:StatelessAuthcFilter <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月28日 上午10:18:45 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class StatelessAuthcFilter extends AccessControlFilter
{

	private final static Logger	log	= LoggerFactory.getLogger(StatelessAuthcFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception
	{
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
	{
		String clientDigest = request.getParameter(Global.SUNEEE_DIGEST);
		String userName = request.getParameter(Global.USER_NAME);
		Map<String, String[]> params = request.getParameterMap();

		AuthenticationToken token = new StatelessToken("admin", "abcd", params);

		try {
			getSubject(request, response).login(token);
		} catch (Exception e) {
			log.error(e.getMessage());
			onLoginFail(response);
			return false;
			
		}

		return true;
	}

	/**
	 * 
	 * @Title: onLoginFail 
	 * @Description: (That's the purpose of the method) 
	 * @param response
	 * @throws
	 */
	private void onLoginFail(ServletResponse response)
	{
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
