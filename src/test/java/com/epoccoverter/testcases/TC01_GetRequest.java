package com.epoccoverter.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.epocconverter.responsevalidation.Responsevalidation;
import com.APIEpocCovereter.teststeps.httpmethods;
import com.epocconverter.utilies.*;

import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC01_Getrequest {
	
	
	public Logger logger;// for logs
	//logs
	
			
	@Test
	public void testcase1_get() throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		logger.info("********** Loading properties file  ***************");
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
	
		
		httpmethods http=new httpmethods(pr);
		System.out.println("******************Test case 1 for valid timestamp***************************");
		
		Response res=http.getrequest("QA_URI");
		
	   logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Responsevalidation.datevalidation(1451613802);
	
	      
		
}
	
	
     @Test
          public void testcase2_invalidtimestamp() throws IOException
      {
	logger= LogManager.getLogger(this.getClass());
	Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
	
	
	httpmethods http=new httpmethods(pr);
	System.out.println("******************Test case 2 for invalid timestamp***************************");
	
	Response res=http.invalid_getrequest("QA_InvalidURI");
	//Response res=http.getrequest_invalid("Base_url","asdfasd");
	
	logger.info("**********Get Request is completed***************");
   Responsevalidation.statuscodevalidation(res, 200);
   Assert.assertEquals(res.asString(), "false");
   
 
      
	
}

	@Test
	public void testcase3_get() throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		logger.info("********** Loading properties file  ***************");
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
		
		
		httpmethods http=new httpmethods(pr);
		System.out.println("******************Test case 3 for timestamp beyond year 2038***************************");
		
		
		Response res=http.getrequest("QA_future");
		//Response res1=http.invalid_getrequest("QA_URL",);
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Responsevalidation.datevalidation(2147483647);
		logger.info("**********Date validation is completed***************");
      }
	
	
	@Test
	public void testcase4_get() throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
		
		
		httpmethods http=new httpmethods(pr);
		System.out.println("******************Test case 4 for Negative unix timestamp***************************");
		
		
		Response res=http.getrequest_futuredate("Base_url1");
		//Response res1=http.invalid_getrequest("QA_URL",);
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Assert.assertEquals(res.asString(), "false");
      }
	
	
	@Test
	public void testcase5_get() throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		logger.info("********** Test case 4 for blank timestamp ***************");
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
		
		
		httpmethods http=new httpmethods(pr);
		System.out.println("******************Test case 5 for Blank unix timestamp***************************");
		
		
		Response res=http.getrequest_futuredate("QA_-veurl");
		//Response res1=http.invalid_getrequest("QA_URL",);
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Responsevalidation.datevalidation(-1451613802);
	 		logger.info("**********Date validation is completed***************");
      }
	
	@Test
	public void testcase6_get() throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
		
		
		httpmethods http=new httpmethods(pr);
		System.out.println("******************Test case 6 for unix timestamp in microseconds with fractional part***************************");
		
		
		Response res=http.getrequest_futuredate("QA_fractional");
		//Response res1=http.invalid_getrequest("QA_URL",);
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);

      }
	
	
	@Test
	public void testcase7_get() throws IOException
	{
		logger= LogManager.getLogger(this.getClass());
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
		
		
		httpmethods http=new httpmethods(pr);
		System.out.println("******************Test case 7 for unix timestamp with very large timestamp***************************");
		
		
		Response res=http.getrequest_futuredate("QA_largetimestamp");
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);

      }
	
}
