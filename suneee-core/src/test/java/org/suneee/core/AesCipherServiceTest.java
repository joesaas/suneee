/**  
 * File Name:AesCipherServiceTest.java  
 * Package Name:org.suneee.core  
 * Description: (That's the purpose of the file)
 * Date:2014年11月28日下午2:46:34  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package org.suneee.core;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;

import com.mysql.jdbc.util.Base64Decoder;

/**  
 * ClassName:AesCipherServiceTest <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年11月28日 下午2:46:34 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class AesCipherServiceTest
{

	public static void main(String[] args) throws Exception
	{
		String name = "liq2312fdwrisdsaomu";
		AesCipherService service = new AesCipherService();

		service.setKeySize(128);

		Key testKey = service.generateNewKey();

		ByteSource enSource = service.encrypt(name.getBytes(), testKey.getEncoded());
		System.out.println(enSource.toString());

		ByteSource deSource = service.decrypt(enSource.getBytes(), testKey.getEncoded());

		System.out.println(new String(deSource.getBytes()));

		//Base64Decoder.decode(in, pos, length)

		PublicEnrypt();
	}

	private static void PublicEnrypt() throws Exception
	{
		Cipher cipher = Cipher.getInstance("RSA");
		//实例化Key  
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		//获取一对钥匙  
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		//获得公钥  
		Key publicKey = keyPair.getPublic();
		//获得私钥   
		Key privateKey = keyPair.getPrivate();
		//用公钥加密  
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal("传智播客".getBytes("UTF-8"));

		//将Key写入到文件  
		saveKey(privateKey, "E:\\zxx_private.key");
		//加密后的数据写入到文件  
		//saveData(result, "public_encryt.dat");
	}

	public static void saveKey(Key key, String fileName) throws Exception
	{
		FileOutputStream fosKey = new FileOutputStream(fileName);
		ObjectOutputStream oosSecretKey = new ObjectOutputStream(fosKey);
		oosSecretKey.writeObject(key);
		oosSecretKey.close();
		fosKey.close();
	}

}
