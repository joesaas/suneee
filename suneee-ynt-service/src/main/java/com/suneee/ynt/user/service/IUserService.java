/**  
 * File Name:IUserService.java  
 * Package Name:com.smart.user.resources  
 * Description: (That's the purpose of the file)
 * Date:2014年11月24日上午10:43:24  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.ynt.user.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.suneee.ynt.user.model.UserModel;

/**  
 * ClassName:IUserService <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月24日 上午10:43:24 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface IUserService
{

	/**
	 * 
	 * @Title: getUserById 
	 * @Description: (That's the purpose of the method) 
	 * @param userId
	 * @return
	 * @throws
	 */
	@GET
	@Path("/getUserById/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("userId") String userId);

	/**
	 * 
	 * @Title: addUser 
	 * @Description: (That's the purpose of the method) 
	 * @param uModel
	 * @return
	 * @throws
	 */
	@POST
	@Path("/addUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(UserModel uModel);
	
	/**
	 * 
	 * @Title: addUser 
	 * @Description: (That's the purpose of the method) 
	 * @param uModels
	 * @return
	 * @throws
	 */
	@POST
	@Path("/addUsers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(List<UserModel> uModels);

	/**
	 * 
	 * @Title: login 
	 * @Description: (That's the purpose of the method) 
	 * @param userId
	 * @return
	 * @throws
	 */
	@GET
	@Path("/login/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("userId") String userId);
}
