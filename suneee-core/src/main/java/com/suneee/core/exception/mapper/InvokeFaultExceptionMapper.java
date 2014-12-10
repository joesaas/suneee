/**  
 * File Name:InvokeFaultExceptionMapper.java  
 * Package Name:com.suneee.core.exception.mapper  
 * Description: (That's the purpose of the file)
 * Date:2014年11月21日下午5:55:28  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
 */

package com.suneee.core.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suneee.core.common.constant.Global;
import com.suneee.core.response.CoreResponse;
import com.suneee.core.utils.ReflectionUtils;

/**
 * ClassName:InvokeFaultExceptionMapper <br/>
 * Description:所有rest请求异常处理类<br/>
 * 
 * @author joe
 * @version V1.0
 * @see
 */
@Provider
public class InvokeFaultExceptionMapper implements ExceptionMapper<Exception>
{

	private static final Logger	log	= LoggerFactory.getLogger(InvokeFaultExceptionMapper.class);

	@Override
	public Response toResponse(Exception ex)
	{

		log.error(ex.getMessage());
		//获取异常对象response属性， 如果有则直接返回
		Object response = ReflectionUtils.getDeclaredField(ex, Global.RESPONSE, Response.class);

		if (response != null) {
			return (Response) response;
		}

		Response resultResponse = CoreResponse.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON)
		        .entity(Global.EMPTY_STRING).build();

		return resultResponse;
	}

}
