/**  
 * File Name:UserModel.java  
 * Package Name:com.smart.user.model  
 * Description: (That's the purpose of the file)
 * Date:2014年11月24日上午10:22:47  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.ynt.user.model;  

import org.apache.ibatis.type.Alias;

import com.suneee.core.model.BaseModel;


/**  
 * ClassName:UserModel <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月24日 上午10:22:47 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
@Alias("userModel")
public class UserModel extends BaseModel {

	/**  
	 * serialVersionUID:That's the purpose of the variable.  
	 */
	private static final long serialVersionUID = -6964229808595178654L;

	private String id ; 
	
	private String userId;
	
	private String userName;
	
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
  
