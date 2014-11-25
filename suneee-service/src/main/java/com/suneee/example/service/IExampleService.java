/**  
 * File Name:IExampleService.java  
 * Package Name:com.suneee.example.service  
 * Description: (That's the purpose of the file)
 * Date:2014年11月19日上午11:23:40  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.example.service;  

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.suneee.core.model.pager.Pager;
import com.suneee.example.model.UserModel;

/**  
 * ClassName:IExampleService <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月19日 上午11:23:40 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface IExampleService {

	/**
	 * 
	 * @Title: getUserVOById 
	 * @Description: get user info by userid. 
	 * @param userId
	 * @return
	 * @throws
	 */
	@GET
	@Path("/getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("userId") Long userId,@QueryParam("") Pager page);
	
	/**
	 * 
	 * @Title: addUser 
	 * @Description: (That's the purpose of the method) 
	 * @param userModel
	 * @return
	 * @throws
	 */
	@POST
	@Path("/addUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(UserModel userModel);
}
  
