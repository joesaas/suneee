/**  
 * File Name:IUserDao.java  
 * Package Name:com.smart.user.dao  
 * Description: (That's the purpose of the file)
 * Date:2014年11月24日上午10:31:20  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.ynt.user.dao;  

import org.springframework.dao.DataAccessException;

import com.suneee.ynt.user.model.UserModel;

/**  
 * ClassName:IUserDao <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月24日 上午10:31:20 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface IUserDao {

	/**
	 * 
	 * @Title: getUserById 
	 * @Description: (That's the purpose of the method) 
	 * @param userId
	 * @return
	 * @throws DataAccessException
	 * @throws
	 */
	public UserModel getUserById(String userId) throws DataAccessException;
}
  
