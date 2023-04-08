package com.epoccoverter.testcases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import com.epocconverter.responsevalidation.Responsevalidation;

import com.epocconverter.utilies.*;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC01_Getrequest {
	
	
	public Logger logger;// for logs
	
	String base_url;
	
	
	@BeforeClass
	public void setup() throws IOException
	{   
		Properties pr=LoadProperties.loadproperties1("../APIEpocConverter/URI.Properties");
		base_url=pr.getProperty("Base_url");
		//logs
		System.out.println("base url is"+base_url);
		
		
		logger= LogManager.getLogger(this.getClass());
		
		logger.debug("debugging.....");
		
	}
	
	
	@Test
	public void testcase1_get() throws IOException
	{
		long s=1451613802;
		System.out.println("******************Test case 1 for valid timestamp***************************");

		Response res=
				given()
				
						  
            .when()
            .get(base_url+s);
		
		 System.out.println("Response is"+res.asString());
		
	   logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Responsevalidation.datevalidation(1451613802);
	
	      
		
}
	
	
     @Test
          public void testcase2_invalidtimestamp() throws IOException
      {
    	 String s="asdfasd";
	System.out.println("******************Test case 2 for invalid timestamp***************************");
	
	Response res=
			given()
						  
        .when()
        .get(base_url+s);
	
	 System.out.println("Response is :"+res.asString());
	
	logger.info("**********Get Request is completed***************");
   Responsevalidation.statuscodevalidation(res, 200);
   Assert.assertEquals(res.asString(), "false");
   logger.info("**********Assertion is completed***************");
 
      
	
}

	@Test
	public void testcase3_get() throws IOException
	{
		
		long s=2147483648L;
	
		System.out.println("******************Test case 3 for timestamp beyond year 2038***************************");
		Response res=
				given()
							  
	        .when()
	        .get(base_url+s);
		
		 System.out.println("Response is :"+res.asString());
		
		

	   Responsevalidation.statuscodevalidation(res, 200);
       Responsevalidation.datevalidation(s);
		logger.info("**********Date validation is completed***************");
  }

	@Test
	public void testcase4_get() throws IOException
	{
	 long s=-1451613802;

	System.out.println("******************Test case 4 for Negative unix timestamp***************************");
		
	Response res=
			given()
						  
        .when()
        .get(base_url+s);
	
	 System.out.println("Response is :"+res.asString());
	 
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Responsevalidation.datevalidation(s);
	}

	@Test
	public void testcase5_get() throws IOException
	{

		System.out.println("******************Test case 5 for Blank unix timestamp***************************");
		Response res=
				given()
							  
	        .when()
	        .get(base_url);
		
		 System.out.println("Response is :"+res.asString());

		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Assert.assertEquals(res.asString(), "false");
	   logger.info("**********Assertion is completed***************");

    }
//	
	@Test
	public void testcase6_get() throws IOException
	{
	 double s=1451613802.123456;
	

		System.out.println("******************Test case 6 for unix timestamp in microseconds with fractional part***************************");
		 Response res=
					given()
								  
		        .when()
		        .get(base_url+s);
			
			 System.out.println("Response is :"+res.asString());
		
		
		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   

   }
	
	
	@Test
	public void testcase7_get() throws IOException
	{
		long s=9999999999999L;

		System.out.println("******************Test case 7 for unix timestamp with very large timestamp***************************");
		 Response res=
					given()
								  
		        .when()
		        .get(base_url+s);
			
			 System.out.println("Response is :"+res.asString());

		logger.info("**********Get Request is completed***************");
	   Responsevalidation.statuscodevalidation(res, 200);
	   Responsevalidation.datevalidation(s);

     }
	}
	

