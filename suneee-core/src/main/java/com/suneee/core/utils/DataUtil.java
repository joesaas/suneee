/**  
 * File Name:DataUtil.java  
 * Package Name:com.suneee.core.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年12月4日上午10:08:17  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suneee.core.common.constant.Global;

/**  
 * ClassName:DataUtil <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月4日 上午10:08:17 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public final class DataUtil
{
	//data util log trace.
	private static final Logger	          log	      = LoggerFactory.getLogger(DataUtil.class);

	private static final SimpleDateFormat	formatter	= new SimpleDateFormat(Global.FORMAT_1);

	private static final Calendar	      calendar	  = Calendar.getInstance();

	/**
	 * 
	 * @Title: getTime 
	 * @Description: (That's the purpose of the method) 
	 * @param format
	 * @return
	 * @throws
	 */
	public static String getTime(String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return getTime(formatter);
	}

	/**
	 * 
	 * @Title: getTime 
	 * @Description: (That's the purpose of the method) 
	 * @param format
	 * @return
	 * @throws
	 */
	public static String getTime(DateFormat format)
	{
		String time = Global.EMPTY;
		try {
			time = format.format(calendar.getTime());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return time;
	}

	/**
	 * 
	 * @Title: getTime 
	 * @Description: (That's the purpose of the method) 
	 * @return
	 * @throws
	 */
	public static String getTime()
	{
		return getTime(formatter);
	}
}
