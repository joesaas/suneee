/**  
 * File Name:BusinessException.java  
 * Package Name:com.suneee.core.exception  
 * Description: (That's the purpose of the file)
 * Date:2014年11月20日上午9:37:54  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.exception;  



/**  
 * ClassName:BusinessException <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月20日 上午9:37:54 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class BusinessException extends Exception {
	
	
	/**
	 * serialVersionUID:That's the purpose of the variable.  
	 */
	private static final long serialVersionUID = -4185219687115482308L;

	/**
	 * 
	 * Creates a new instance of BusinessException.
	 */
	public BusinessException(){
		
	}
	
	/**
	 * 
	 * Creates a new instance of BusinessException.  
	 * @param message
	 */
	public BusinessException(String messageKey){
		super(messageKey);
	}
	
	/**
	 * 
	 * Creates a new instance of BusinessException.  
	 * @param cause
	 */
	public BusinessException(Throwable cause){
		super(cause);
	}
	
	/**
	 * 
	 * Creates a new instance of BusinessException.  
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause){
		super(message, cause);
	}
	
}
  
