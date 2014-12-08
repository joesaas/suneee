/**  
 * File Name:RequestUtil.java  
 * Package Name:com.suneee.core.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年12月5日下午4:42:06  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**  
 * ClassName:RequestUtil <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月5日 下午4:42:06 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public final class HttpRequestUtil
{

	public static void convert(HttpServletRequest request, Map<String, String> params)
	{
		if (request == null || params == null) {
			return ;
		}
		
		try {
			 ServletInputStream stream =  request.getInputStream();
        } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        
        }
	}
}
