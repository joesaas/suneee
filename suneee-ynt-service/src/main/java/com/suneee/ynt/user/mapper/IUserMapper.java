/**  
 * File Name:IUserMapper.java  
 * Package Name:com.smart.user.mapper  
 * Description: (That's the purpose of the file)
 * Date:2014年11月24日上午10:26:59  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.ynt.user.mapper;  

import com.suneee.core.mapper.IDataSourceMapper;
import com.suneee.ynt.user.model.UserModel;

/**  
 * ClassName:IUserMapper <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月24日 上午10:26:59 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public interface IUserMapper extends IDataSourceMapper {

	public UserModel getUserById(String userId);
}
  
