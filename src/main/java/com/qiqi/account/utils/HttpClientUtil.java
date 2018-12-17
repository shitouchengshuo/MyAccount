package com.qiqi.account.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 利用HttpClient进行基于http的RPC工具类
 */
public class HttpClientUtil {
	public static String doPost(String url,Map<String,String> map,String authorization){
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try{
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			if(authorization!=null){
				httpPost.addHeader("Authorization", authorization);
			}
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,"utf-8");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static String doPostCustomer(String url,Map<String,String> map,String authorization,String connectTimeout,String soTimeout){
		String result = null;
		try{
			BasicHttpParams httpParams = new BasicHttpParams();  
	        HttpConnectionParams.setConnectionTimeout(httpParams, Integer.parseInt(connectTimeout));  
	        HttpConnectionParams.setSoTimeout(httpParams, Integer.parseInt(soTimeout));  
	    	DefaultHttpClient client = new DefaultHttpClient(httpParams);
	    	
			HttpPost httpPost = new HttpPost(url);
			if(authorization!=null){
				httpPost.addHeader("Authorization", authorization);
			}
			//设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String,String> elem = (Entry<String, String>) iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
			}
			if(list.size() > 0){
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
				httpPost.setEntity(entity);
			}
			HttpResponse response = client.execute(httpPost);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,"utf-8");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	 /**
     * post请求
     * @param url
     * @param json
     * @return
     */
    public static JSONObject doPost(String url,JSONObject json,String connectTimeout,String soTimeout){
    	//init client
    	BasicHttpParams httpParams = new BasicHttpParams();  
        HttpConnectionParams.setConnectionTimeout(httpParams, Integer.parseInt(connectTimeout));  
        HttpConnectionParams.setSoTimeout(httpParams, Integer.parseInt(soTimeout));  
    	DefaultHttpClient client = new DefaultHttpClient(httpParams);

        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString(),"utf-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity(),"UTF-8");// 返回json格式：
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
	
	public static String doGet(String url,String params,String authorization){
		HttpClient httpClient = null;
		String result = null;
		if(params!=null){
			url=url +"?"+ params;
		}
		try{
			httpClient = new SSLClient();
			HttpGet get = new HttpGet(url);
			if(authorization!=null){
				get.addHeader("Authorization", authorization);
			}
			HttpResponse response = httpClient.execute(get);
			if(response != null){
				HttpEntity resEntity = response.getEntity();
				if(resEntity != null){
					result = EntityUtils.toString(resEntity,"utf-8");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
		
	}
	
	
}








