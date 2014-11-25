/**  
 * File Name:RedisTemplateHandle.java  
 * Package Name:com.suneee.core.cache  
 * Description: (That's the purpose of the file)
 * Date:2014年11月20日上午11:29:00  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.redis;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**  
 * ClassName:RedisTemplateHandle <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月20日 上午11:29:00 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class RedisTemplateHandle<K, V> {

	@Autowired
	private RedisTemplate<K, V> redisTemplate;
	
}
  
