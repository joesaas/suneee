/**  
 * File Name:RoleEnum.java  
 * Package Name:com.suneee.core.enums  
 * Description: (That's the purpose of the file)
 * Date:2014年12月4日下午5:36:57  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.enums;  
/**  
 * ClassName:RoleEnum <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月4日 下午5:36:57 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public enum RoleEnum
{
	/**
	 *  客户端角色定义， 根据不同的角色限制用户访问不同的模块.
	 *  visitor : 游客角色  
	 *  general_user   : 普通用户 (未绑定终端)
	 *  只有注册后的用户才会存在以下角色：
	 *  terminal_admin : 终端管理员 
	 *  terminal_driver ： 终端司机
	 */
	VISITOR("visitor"), GENERAL_USER("general_user"), TERMINAL_ADMIN("terminal_admin"), TERMINAL_DRIVER("terminal_driver");
	
	private RoleEnum(String roleName){
		this.roleName = roleName;
	}
	
	private String roleName;

	public String toString()
	{
	    return this.roleName;
	}
}
  
