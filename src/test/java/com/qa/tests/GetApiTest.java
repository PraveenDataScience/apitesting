package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase {
	
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	
	@BeforeMethod
	public void setUp()
	{
		testBase=new TestBase();
		serviceUrl=prop.getProperty("URL");
		apiUrl=prop.getProperty("serviceURL");
		
		url=serviceUrl+apiUrl;
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException
	{
		restClient=new RestClient();
		restClient.get(url);
	}

}
