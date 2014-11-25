/**  
 * File Name:SpringContextLoaderListener.java  
 * Package Name:com.suneee.core.listener  
 * Description: (That's the purpose of the file)
 * Date:2014年11月20日下午3:27:30  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.listener;  

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.suneee.core.utils.ApplicationContextUtil;

/**  
 * ClassName:SpringContextLoaderListener <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月20日 下午3:27:30 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class SpringContextLoaderListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());
		ApplicationContextUtil.setApplicationContext(applicationContext);
	}
}
  
