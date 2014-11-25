/**  
 * File Name:UserService.java  
 * Package Name:com.smart.user.resources  
 * Description: (That's the purpose of the file)
 * Date:2014年11月24日上午10:47:30  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.ynt.user.service;  

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suneee.core.response.CoreResponse;
import com.suneee.ynt.user.dao.IUserDao;
import com.suneee.ynt.user.model.UserModel;

/**  
 * ClassName:UserService <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月24日 上午10:47:30 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
@Service("userService")
public class UserService implements IUserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserDao userDao;
	
	/**
	 * 
	 * @see com.suneee.ynt.user.service.IUserService#getUserById(java.lang.String)
	 */
	@RequiresPermissions({"user:find"})
	public Response getUserById(String userId) {
		log.info("test+++++++++++++++++++++++++");
		UserModel userModel = userDao.getUserById(userId);
		Response response = CoreResponse.ok(userModel).status(Status.OK).build();
		return response;
	}

}
  
