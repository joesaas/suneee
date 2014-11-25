/**  
 * File Name:PropertiesUtil.java  
 * Package Name:com.suneee.core.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年11月19日下午3:36:29  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.utils;  

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**  
 * ClassName:PropertiesUtil <br/>  
 * Description:
 * Date:     2014年11月19日 下午3:36:29 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public final class PropertiesUtil extends PropertyPlaceholderConfigurer{
	
	private final static Logger log = LoggerFactory.getLogger(PropertiesUtil.class);
	
	private static Map<String, String> configProper = new HashMap<String, String>();

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for(Object key : props.keySet()){
			String keyStr = key.toString();
			String value  = props.getProperty(key.toString());
			log.info("加载自定义配置文件================[ key:===== {},  value:==== {} ]", keyStr, value);
			configProper.put(keyStr , value);
		}
	}
	
	/**
	 * 
	 * @Title: getProperty 
	 * @Description: 获取配置文件的key对应的value， 如果value为空返回默认值
	 * @param key
	 * @param defaultStr
	 * @return
	 * @throws
	 */
	public static final String getProperty(String key, String defaultStr){
		String value = configProper.get(key);
		return value == null ? defaultStr : value;
	}
	
	/**
	 * 
	 * @Title: getProperty 
	 * @Description: 获取配置文件的key对应的value，如果value为空返回空。
	 * @param key
	 * @return
	 * @throws
	 */
	public static final String getProperty(String key){
		return configProper.get(key);
	}
}
  
