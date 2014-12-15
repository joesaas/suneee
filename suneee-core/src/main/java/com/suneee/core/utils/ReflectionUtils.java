/**  
 * File Name:ReflectionUtils.java  
 * Package Name:com.suneee.core.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年12月9日下午4:48:52  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**  
 * ClassName:ReflectionUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月9日 下午4:48:52 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public final class ReflectionUtils
{
	private final static Logger	log	= LoggerFactory.getLogger(ReflectionUtils.class);

	/**
	 * 
	 * @Title: getDeclaredField 
	 * @Description: (That's the purpose of the method) 
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws
	 */
	public static Object getDeclaredField(Object obj, String fieldName)
	{
		return getDeclaredField(obj, fieldName, Object.class);
	}

	/**
	 * 
	 * @Title: getDeclaredField 
	 * @Description: (That's the purpose of the method) 
	 * @param obj
	 * @param fieldName
	 * @param targetClass
	 * @return
	 * @throws
	 */
	public static Object getDeclaredField(Object obj, String fieldName, Class<?> targetClass)
	{
		if (obj == null || targetClass == null || StringUtils.isEmpty(fieldName)) {
			return null;
		}

		Class<?> clazz = obj.getClass();

		Field filed = null;
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				filed = clazz.getDeclaredField(fieldName);
				filed.setAccessible(true);
				Object result = filed.get(obj);
				targetClass.isInstance(result);
				return result;
			} catch (NoSuchFieldException | SecurityException e) {
				log.error(e.getMessage());
			} catch (IllegalArgumentException e) {
				log.error(e.getMessage());
			} catch (IllegalAccessException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}

}
