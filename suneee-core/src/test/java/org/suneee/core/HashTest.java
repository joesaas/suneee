/**  
 * File Name:HashTest.java  
 * Package Name:org.suneee.core  
 * Description: (That's the purpose of the file)
 * Date:2014年12月5日下午2:23:25  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package org.suneee.core;  

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.hash.Md5Hash;


/**  
 * ClassName:HashTest <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月5日 下午2:23:25 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class HashTest
{

	public static void main(String[] args) throws UnsupportedEncodingException
    {
	    Md5Hash md5 = new Md5Hash("liqiaomu");
	    
	    System.out.println(md5.toHex());
	    System.out.println(md5.toBase64());
	    System.out.println(md5.toString());
	    
	    System.out.println(encodeMD5Password("liqiaomu"));
	    
	    byte[] b = "liqiaomu".getBytes();
    }
	
	public static String encodeMD5Password(String plainText) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
		byte[] b = md.digest(plainText.getBytes());
		StringBuffer sb = new StringBuffer(b.length);
		String sTemp;
		for (int i = 0; i < b.length; i++) {
			sTemp = Integer.toHexString(0xFF & b[i]);
			System.out.println(sTemp);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toLowerCase());
		}
		return sb.toString();
	}
}
  
