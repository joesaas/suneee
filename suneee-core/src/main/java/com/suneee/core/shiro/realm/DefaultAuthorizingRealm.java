/**  
 * File Name:DefaultAuthorizingRealm.java  
 * Package Name:com.suneee.core.shiro  
 * Description: (That's the purpose of the file)
 * Date:2014年11月28日上午9:41:02  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.AllPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.suneee.core.shiro.token.StatelessToken;

/**  
 * ClassName:DefaultAuthorizingRealm <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月28日 上午9:41:02 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class DefaultAuthorizingRealm extends AuthorizingRealm
{
	/**
	 * 
	 * TODO  
	 * @see org.apache.shiro.realm.AuthenticatingRealm#supports(org.apache.shiro.authc.AuthenticationToken)
	 */
	public boolean supports(AuthenticationToken token) {  
        //仅支持StatelessToken类型的Token  
        return token instanceof StatelessToken;  
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{

		String userName = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		
		//authorizationInfo.addObjectPermission( new AllPermission());
		authorizationInfo.addStringPermission("user:find");
		authorizationInfo.addRole("admin");
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
	{
		StatelessToken statelessToken = (StatelessToken) token;
		
		String userName = (String) statelessToken.getPrincipal();
		userName="admin";
		String key = getKey(userName);
		return new SimpleAuthenticationInfo(userName, key, getName());
	}

	private String getKey(String userName)
	{
		return "abcd";
	}

}
