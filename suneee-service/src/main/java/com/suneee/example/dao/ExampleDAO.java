/**  
 * File Name:ExampleDAO.java  
 * Package Name:com.suneee.example.dao  
 * Description: (That's the purpose of the file)
 * Date:2014年11月18日下午5:21:58  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.example.dao;  

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.suneee.example.mapper.ExampleMapper;
import com.suneee.example.model.UserModel;

/**  
 * ClassName:ExampleDAO <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月18日 下午5:21:58 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
@Repository
public class ExampleDAO implements IExampleDAO {
	
	@Autowired
	private ExampleMapper exampleMapper;
	
	// inject the actual template
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, List<String>> listOps;
	
	public UserModel getUserById(Long userId) throws DataAccessException {
		ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
		UserModel userModel = (UserModel) valueOps.get(userId);
		return exampleMapper.getUserById(userId);
	}
	
	public boolean addUser(UserModel userVO) {
		ValueOperations<String, Object> valueOps =redisTemplate.opsForValue();
		valueOps.set(userVO.getName(), userVO);
		return true;
	}

}

