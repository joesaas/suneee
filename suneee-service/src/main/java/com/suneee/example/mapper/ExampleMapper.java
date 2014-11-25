/**  
 * File Name:ExampleMapper.java  
 * Package Name:com.suneee.example.dao  
 * Description: (That's the purpose of the file)
 * Date:2014年11月18日下午5:05:07  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.example.mapper;  

import org.springframework.dao.DataAccessException;

import com.suneee.core.mapper.IDataSourceMapper;
import com.suneee.example.model.UserModel;

/**  
 * ClassName:ExampleMapper <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月18日 下午5:05:07 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface ExampleMapper extends IDataSourceMapper {
	
	
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
  
