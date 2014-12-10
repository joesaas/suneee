/**  
 * File Name:HttpClientUtils.java  
 * Package Name:com.suneee.core.http.utils  
 * Description: (That's the purpose of the file)
 * Date:2014年12月3日下午4:00:02  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/

package com.suneee.core.http.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.common.util.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suneee.core.common.constant.Global;
import com.suneee.core.exception.ApplicationException;
import com.suneee.core.http.exception.HttpClientApplicationException;
import com.suneee.core.utils.PropertiesUtil;

/**  
 * ClassName:HttpClientUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月3日 下午4:00:02 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public final class HttpClientUtils
{
	private static final Logger	             log	        = LoggerFactory.getLogger(HttpClientUtils.class);

	//请求超时设置
	private static final String	             connectTimeout	= PropertiesUtil.getProperty(Global.HTTP_CONNECT_TIMEOUT,
	                                                                String.valueOf(Global.I_60000));
	//socket 通信超时设置
	private static final String	             socketTimeout	= PropertiesUtil.getProperty(Global.SOCKET_TIMEOUT,
	                                                                String.valueOf(Global.I_15000));

	private static final String	             ERROR_001	    = "url is null";

	private final static CloseableHttpClient	httpClient;

	static {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(Integer.valueOf(connectTimeout))
		        .setSocketTimeout(Integer.valueOf(socketTimeout)).build();
		httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	}

	public static final Object doGet(String url, Map<String, String> params) throws ApplicationException
	{
		return doGet(url, params, Global.UTF_8);
	}

	public static final Object doPost(String url, Map<String, String> params) throws ApplicationException
	{
		return doPost(url, params, Global.UTF_8);
	}

	/**
	 * 
	 * @Title: doPost 
	 * @Description: (http client post) 
	 * @param url
	 * @param params
	 * @param utf8
	 * @return
	 * @throws
	 */
	private static Object doPost(String url, Map<String, String> params, String charset) throws ApplicationException
	{
		if (StringUtils.isEmpty(url)) {
			log.error(ERROR_001);
			throw new HttpClientApplicationException(ERROR_001);
		}
		String result = null;
		CloseableHttpResponse cResponse = null;
		try {
			HttpPost hPost = new HttpPost(url);
			hPost.setEntity(new UrlEncodedFormEntity(constructorParams(params), charset));
			cResponse = httpClient.execute(hPost);
			HttpEntity entity = cResponse.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, charset);
			}
			EntityUtils.consume(entity);
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
			throw new HttpClientApplicationException(e);
		} finally {
			if (cResponse != null) {
				try {
					cResponse.close();
				} catch (IOException e) {
					log.error(e.getMessage());
					throw new HttpClientApplicationException(e);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @Title: doGet 
	 * @Description: http client get
	 * @param url
	 * @param params
	 * @param charset
	 * @return
	 * @throws ApplicationException
	 * @throws
	 */
	public static final Object doGet(String url, Map<String, String> params, String charset)
	        throws ApplicationException
	{
		if (StringUtils.isEmpty(url)) {
			log.error(ERROR_001);
			throw new HttpClientApplicationException(ERROR_001);
		}

		StringBuilder sbulid = new StringBuilder(url);
		String result = null;
		try {
			//构造请求参数
			String paramStr = EntityUtils.toString(new UrlEncodedFormEntity(constructorParams(params), charset));
			sbulid.append(Global.S_WHAT).append(paramStr);

			log.debug(sbulid.toString());
			HttpGet hGet = new HttpGet(sbulid.toString());

			hGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML);

			CloseableHttpResponse cResponse = httpClient.execute(hGet);
			HttpEntity hEntity = cResponse.getEntity();
			if (hEntity != null) {
				result = EntityUtils.toString(hEntity, Global.UTF_8);
			}
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
			throw new HttpClientApplicationException(e);
		}

		return result;
	}

	/**
	 * 
	 * @Title: constructorParams 
	 * @Description: (map<String, String> 转换为 List<NameValuePair>) 
	 * @param params
	 * @return
	 * @throws
	 */
	private static final List<NameValuePair> constructorParams(Map<String, String> params)
	{
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if (!CollectionUtils.isEmpty(params)) {

			for (Map.Entry<String, String> entry : params.entrySet()) {
				if (StringUtils.isEmpty(entry.getKey())) {
					continue;
				}
				pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}

		return pairs;
	}
}
