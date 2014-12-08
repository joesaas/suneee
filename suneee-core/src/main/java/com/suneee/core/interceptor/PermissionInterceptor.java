/**  
 * File Name:PermissionInterceptor.java  
 * Package Name:com.suneee.core.interceptor  
 * Description: (That's the purpose of the file)
 * Date:2014年12月8日下午3:37:32  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.interceptor;

import java.util.List;

import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suneee.core.common.constant.Global;
import com.suneee.core.model.AuthcModel;
import com.suneee.core.shiro.token.StatelessToken;
import com.suneee.core.utils.ReflectionUtils;

/**  
 * ClassName:PermissionInterceptor <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月8日 下午3:37:32 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class PermissionInterceptor extends AbstractPhaseInterceptor<Message>
{

	private static final Logger	log	= LoggerFactory.getLogger(PermissionInterceptor.class);

	public PermissionInterceptor() {
		super(Phase.PRE_LOGICAL);
	}

	@Override
	public void handleMessage(Message message) throws Fault
	{
		Object obj = getInvokee(message);
		if (obj == null) {
			return;
		}

		List<Object> params = null;
		if (obj instanceof List) {
			params = CastUtils.cast((List<?>) obj);
		} else if (obj != null) {
			params = new MessageContentsList(obj);
		}

		/**
		 * 获取用户认证信息， 只需要对实现认证接口的modle进行验证
		 */
		AuthcModel autchModel = null;
		for (Object o : params) {
			Object authcObj = ReflectionUtils.getDeclaredField(o, Global.AUTHC);
			if (authcObj != null && authcObj instanceof AuthcModel) {
				autchModel = (AuthcModel) authcObj;
				break;
			}
		}
		if (autchModel == null) {
			return;
		}
		
		AuthenticationToken token = new StatelessToken(autchModel.getUserName(), autchModel.getSuneeeDigest(), null);
		try {
			SecurityUtils.getSubject().login(token);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private Object getInvokee(Message message)
	{
		Object invokee = message.getContent(List.class);
		if (invokee == null) {
			invokee = message.getContent(Object.class);
		}
		return invokee;
	}

}
