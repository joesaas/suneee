/**  
 * File Name:SystemException.java  
 * Package Name:com.suneee.core.exception  
 * Description: (That's the purpose of the file)
 * Date:2014年11月20日上午9:42:08  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.exception;  
/**  
 * ClassName:SystemException <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月20日 上午9:42:08 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class SystemException extends RuntimeException {

	/**  
	 * serialVersionUID:That's the purpose of the variable.  
	 */
	private static final long serialVersionUID = -5375951493316918015L;

	/**
	 * 
	 * Creates a new instance of SystemException.
	 */
	public SystemException(){
		
	}
	
	/**
	 * 
	 * Creates a new instance of SystemException.  
	 * @param message
	 */
	public SystemException(String message){
		super(message);
	}
	
	/**
	 * 
	 * Creates a new instance of SystemException.  
	 * @param cause
	 */
	public SystemException(Throwable cause){
		super(cause);
	}
	
	/**
	 * 
	 * Creates a new instance of SystemException.  
	 * @param message
	 * @param cause
	 */
	public SystemException(String message, Throwable cause){
		super(message, cause);
	}
}
  
