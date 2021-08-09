package com.song.springboot.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Slf4j
public class HttpClientUtil {

	//private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

	private static final String APPLICATION_JSON = "application/json";

	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

	/**
	 * 发送Post请求
	 * @return :
	 * @params : url params encoding connectTimeOut
	 */
	public static String sendPost(String url, Map<String, String> params, String encoding, int connectTimeOut) {
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// 创建CloseableHttpClient对象
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		// 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeOut)
				.setConnectTimeout(connectTimeOut).build();
		//setConfig  setHeads ..
		httpPost.setConfig(requestConfig);
		try {
			// 加入参数
			if (null != params && !params.isEmpty()) {
				// 创建参数list
				List<NameValuePair> formParams = new ArrayList<>();
				for (Entry<String, String> param : params.entrySet()) {
					if (null != param.getValue()) {
						formParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
					}
				}
				httpPost.setEntity(new UrlEncodedFormEntity(formParams, encoding));
			}
			// 发送请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
			// 获取请求结果 httpResponse.getStatusLine()
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				return EntityUtils.toString(httpEntity, encoding);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				closeableHttpClient.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 发送Get请求
	 * @return :
	 * @params : url params encoding connectTimeOut
	 */
	public static String sendGet(String url, Map<String, String> params, String encoding, int connectTimeOut) {
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(connectTimeOut)
				.setConnectTimeout(connectTimeOut).build();// 设置请求和传输超时时间
		httpGet.setConfig(requestConfig);
		try {
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			// 获取响应消息实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 响应状态
			// 判断响应实体是否为空
			if (httpEntity != null) {
				return EntityUtils.toString(httpEntity, encoding);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流并释放资源
				closeableHttpClient.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 使用httpClient发送Json参数
	 * @return :
	 * @params :
	 */
	public static void httpPostWithJSON(String url, String json) {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpPost
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		// 将JSON进行UTF-8编码,以便传输中文
		StringEntity encoderJson = new StringEntity(json, "UTF-8");   // 中文乱码在此解决
		encoderJson.setContentType(CONTENT_TYPE_TEXT_JSON);
		encoderJson.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
		CloseableHttpResponse response = null;
		try {
			httpPost.setEntity(encoderJson);
			response = httpClient.execute(httpPost);
			log.info("返回结果Response :" + response);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				log.info("Response content: " + EntityUtils.toString(entity, "UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpClient.close();
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发送Post请求
	 * @return :
	 * @params : url,param,encoding
	 */
	public static String sendPost(String url, Map<String, String> param, String encoding) {
		return sendPost(url, param, encoding, 3000);
	}

	/**
	 * 发送Post请求
	 * @return :
	 * @params : url,param
	 */
	public static String sendPost(String url, Map<String, String> param) {
		return sendPost(url, param, "UTF-8", 3000);
	}

	/**
	 * 发送Get请求
	 * @return :
	 * @params :  param encoding
	 */
	public static String sendGet(String url, Map<String, String> param, String encoding) {
		return sendGet(url, param, encoding, 3000);
	}

	/**
	 * 发送Get请求
	 * @return :
	 * @params : url param
	 */
	public static String sendGet(String url, Map<String, String> param) {
		return sendGet(url, param, "UTF-8", 3000);
	}
}
