package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient  httpClient=HttpClients.createDefault();// To create http connection using HttpClients class
		HttpGet httpget=new HttpGet(url);// http get request
		CloseableHttpResponse  closeableHttpResponse=httpClient.execute(httpget);
		
		//To get the StatusCode:
		int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code ----> "+statusCode);
		
		// To get Response body:
		String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("Response in JSON "+responseJson);
		
		// To get Headers:
		Header[] headersArray=closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allheader=new HashMap<String,String>();		
		for(Header header : headersArray )
		{
			allheader.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers: "+headersArray);
	}

}
