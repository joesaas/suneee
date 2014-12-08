/**  
 * File Name:RandomUtil.java  
 * Package Name:com.suneee.core.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年12月5日下午3:26:04  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.utils;

import java.util.Random;

/**  
 * ClassName:RandomUtil <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月5日 下午3:26:04 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class RandomUtil
{
	/**
	 * 随机产生几位数字：例：maxLength=3,则结果可能是 012
	 */
	public static final int produceNumber(int maxLength)
	{
		Random random = new Random();
		return random.nextInt(maxLength);
	}

	/**
	 * 随机产生区间数字：例：minNumber=1,maxNumber=2,则结果可能是 1、2,包括首尾。
	 */
	public static int produceRegionNumber(int minNumber, int maxNumber)
	{
		return minNumber + produceNumber(maxNumber);
	}

	/**
	 * 随机产生几位字符串：例：maxLength=3,则结果可能是 aAz
	 * @param maxLength 传入数必须是正数。
	 */
	public static String produceString(int maxLength)
	{
		String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return doProduce(maxLength, source);
	}

	/**
	 * 随机产生随机数字+字母：例：maxLength=3,则结果可能是 1Az
	 * @param maxLength 传入数必须是正数。
	 */
	public static String produceStringAndNumber(int maxLength)
	{
		String source = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return doProduce(maxLength, source);
	}

	/**
	 * 自定义随机产生结果
	 */
	public static String produceResultByCustom(String customString, int maxLength)
	{
		return doProduce(maxLength, customString);
	}

	/**
	 * 生产结果
	 */
	private static String doProduce(int maxLength, String source)
	{
		StringBuffer sb = new StringBuffer(100);
		for (int i = 0; i < maxLength; i++) {
			final int number = produceNumber(source.length());
			sb.append(source.charAt(number));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(RandomUtil.produceStringAndNumber(64));
	}
}
