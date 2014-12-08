/**  
 * File Name:HttpClientUtils.java  
 * Package Name:org.suneee.core.http  
 * Description: (That's the purpose of the file)
 * Date:2014年12月3日下午5:43:50  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package org.suneee.core.http;  

import java.util.HashMap;

import com.suneee.core.exception.ApplicationException;
import com.suneee.core.http.utils.HttpClientUtils;

/**  
 * ClassName:HttpClientUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月3日 下午5:43:50 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class HttpClientUtilsTest
{
	private static String url = "http://localhost:8080/suneee-ynt-web/rest/user/addUser";
	public static void main(String[] args)
	{
		try {
	       String obj =  (String) HttpClientUtils.doGet(url, new HashMap<String, String>());
	       System.out.println("==========");
	       System.out.println(obj.toString());
        } catch (ApplicationException e) {
	        e.printStackTrace();  
        }
	}

}
  
