/**  
 * File Name:ExampleService.java  
 * Package Name:com.suneee.example.service  
 * Description: (That's the purpose of the file)
 * Date:2014年11月17日上午10:47:19  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.example.service;  

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suneee.core.model.pager.Pager;
import com.suneee.core.response.CoreResponse;
import com.suneee.example.dao.IExampleDAO;
import com.suneee.example.model.UserModel;

/**  
 * ClassName:ExampleService <br/>  
 * Description: example service.
 * Date:     2014年11月17日 上午10:47:19 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see       
 */
@Service("exampleService")
public class ExampleService implements IExampleService{
	
	//ExampleService log trace
	private static final Logger log = LoggerFactory.getLogger(ExampleService.class);
	
	@Autowired
	private IExampleDAO exampleDAO;
	

	/**
	 * 
	 * @see com.suneee.example.service.IExampleService#getUserVOById(java.lang.Long)
	 */
	public Response getUserById(Long userId, Pager page) {
		log.debug("getUser userId: {1}", userId);
		UserModel userVO = exampleDAO.getUserById(userId);
		if( null == userVO){
			return CoreResponse.status(Status.NOT_FOUND).build();
		}
		return CoreResponse.ok(userVO).status(Status.OK).build();
	}
	
	/**
	 * TODO  
	 * @see com.suneee.example.service.IExampleService#addUser(com.suneee.example.model.UserModel)
	 */
	public Response addUser(UserModel userModel){
		System.out.println(userModel.getPassword() == null);
		return CoreResponse.ok("ok").status(Status.OK).build();
	}

}
  
