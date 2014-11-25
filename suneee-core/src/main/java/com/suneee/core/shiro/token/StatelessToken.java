/**  
 * File Name:StatelessToken.java  
 * Package Name:com.suneee.core.shiro.token  
 * Description: (That's the purpose of the file)
 * Date:2014年11月28日上午9:43:48  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
 */

package com.suneee.core.shiro.token;

import java.util.Map;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * ClassName:StatelessToken <br/>
 * Description:That's the purpose of the class Date: 2014年11月28日 上午9:43:48 <br/>
 * 
 * @author joe
 * @version V1.0
 * @see
 */
public class StatelessToken implements AuthenticationToken
{

	/**
	 * serialVersionUID:That's the purpose of the variable.
	 */
	private static final long	serialVersionUID	= -7912333443501179249L;

	private String				userName;

	private Map<String, ?>		params;

	private String				clientDigest;

	public StatelessToken(String _userName, String _clientDigest, Map<String, ?> _params) {
		this.userName = _userName;
		this.clientDigest = _clientDigest;
		this.params = _params;
	}

	@Override
	public Object getPrincipal()
	{
		return userName;
	}

	@Override
	public Object getCredentials()
	{
		return clientDigest;
	}

}
