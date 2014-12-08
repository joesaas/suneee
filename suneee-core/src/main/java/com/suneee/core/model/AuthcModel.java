/**  
 * File Name:CoreModel.java  
 * Package Name:com.suneee.core.model  
 * Description: (That's the purpose of the file)
 * Date:2014年12月8日下午5:12:07  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.model;

/**  
 * ClassName:CoreModel <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月8日 下午5:12:07 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class AuthcModel implements IAuthcModel
{

	/**  
	 * serialVersionUID:That's the purpose of the variable.  
	 */
	private static final long	serialVersionUID	= 8520558634570244611L;

	private String	          userName;

	private String	          password;

	private String	          suneeeDigest;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSuneeeDigest()
	{
		return suneeeDigest;
	}

	public void setSuneeeDigest(String suneeeDigest)
	{
		this.suneeeDigest = suneeeDigest;
	}
}
