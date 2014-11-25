/**  
 * File Name:ApplicationContextUtil.java  
 * Package Name:com.suneee.core.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年11月20日下午3:21:25  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.utils;  

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**  
 * ClassName:ApplicationContextUtil <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月20日 下午3:21:25 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class ApplicationContextUtil {

	private static ApplicationContext applicationContext ;

	
	/**
	 * 
	 * @Title: setApplicationContext 
	 * @Description: (That's the purpose of the method) 
	 * @param _applicationContext
	 * @throws BeansException
	 * @throws
	 */
	public static void setApplicationContext(ApplicationContext _applicationContext) throws BeansException
	{
		 applicationContext = _applicationContext;
	}
	
	/**
	 * 
	 * @Title: getBean 
	 * @Description: (That's the purpose of the method) 
	 * @param name
	 * @return
	 * @throws BeansException
	 * @throws
	 */
	public static Object getBean(String name) throws BeansException
	{
		return applicationContext.getBean(name);
	}
	
	/**
	 * 
	 * @Title: getApplicationcontext 
	 * @Description: (That's the purpose of the method) 
	 * @return
	 * @throws
	 */
	public static ApplicationContext getApplicationcontext() {
		return applicationContext;
	} 
	
}
  
