/**  
 * File Name:UserVO.java  
 * Package Name:com.suneee.example.model  
 * Description: (That's the purpose of the file)
 * Date:2014年11月17日上午10:49:33  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.example.model;  


import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.suneee.core.model.BaseModel;

/**  
 * ClassName:UserVO <br/>  
 * Description: user model infomation.
 * Date:     2014年11月17日 上午10:49:33 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
@Alias("userModel")
public class UserModel extends BaseModel{
	
	/**  
	 * serialVersionUID:That's the purpose of the variable.  
	 */
	private static final long serialVersionUID = -3920613042211561054L;

	/**
	 * user name;
	 */
	private String name;
	
	/**
	 * user password.
	 */
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
  
