/**  
 * File Name:HttpApplicationException.java  
 * Package Name:com.suneee.core.http.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年12月3日下午4:39:49  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.http.exception;  

import com.suneee.core.exception.ApplicationException;

/**  
 * ClassName:HttpApplicationException <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月3日 下午4:39:49 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class HttpClientApplicationException extends ApplicationException
{

	/**  
	 * serialVersionUID:That's the purpose of the variable.  
	 */
    private static final long serialVersionUID = -5905428221844109513L;

    /**
     * 
     * Creates a new instance of HttpClientApplicationException.  
     * @param message
     */
    public HttpClientApplicationException(String message){
    	super(message);
    }
    
    /**
     * 
     * Creates a new instance of HttpClientApplicationException.  
     * @param message
     * @param cause
     */
    public HttpClientApplicationException(String message, Throwable cause){
    	super(message, cause);
    }
    
    /**
     * 
     * Creates a new instance of HttpClientApplicationException.  
     * @param cause
     */
    public HttpClientApplicationException(Throwable cause){
    	super(cause);
    }
}
  
