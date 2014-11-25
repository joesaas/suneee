/**  
 * File Name:UserDao.java  
 * Package Name:com.smart.user.dao  
 * Description: (That's the purpose of the file)
 * Date:2014年11月24日上午10:32:40  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.ynt.user.dao;  

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.suneee.ynt.user.mapper.IUserMapper;
import com.suneee.ynt.user.model.UserModel;

/**  
 * ClassName:UserDao <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月24日 上午10:32:40 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
@Repository
public class UserDao implements IUserDao {
	
	@Autowired
	private IUserMapper userMapper;

	@Override
	public UserModel getUserById(String userId) throws DataAccessException {
		if(StringUtils.isEmpty(userId) || !StringUtils.isNumeric(userId)){
			return null;
		}
		return userMapper.getUserById(userId);
	}

}
  
