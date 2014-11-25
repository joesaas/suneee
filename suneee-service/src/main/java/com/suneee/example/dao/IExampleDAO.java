/**  
 * File Name:IExampleDAO.java  
 * Package Name:com.suneee.example.dao  
 * Description: (That's the purpose of the file)
 * Date:2014年11月17日上午10:53:09  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.example.dao;  

import org.springframework.dao.DataAccessException;

import com.suneee.example.model.UserModel;

/**  
 * ClassName:IExampleDAO <br/>  
 * Description: example dao.
 * Date:     2014年11月17日 上午10:53:09 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface IExampleDAO {
	
	/**
	 * 
	 * @Title: getUserById 
	 * @Description: get user info bu userid.
	 * @param userId
	 * @return
	 * @throws DataAccessException
	 * @throws
	 */
	public UserModel getUserById(Long userId) throws DataAccessException ;
	
}
  
