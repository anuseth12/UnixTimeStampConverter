package com.epoccoverter.testcases;

import org.json.JSONArray;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class TC01_GetRequest {

	
	
	@Test
	
	  public void testUnixTimestampConverterAPI()
	{
		Response res=
				given()
			//.pathParam("timestamp", "unix-timestamp-converter")
			.queryParam("cached","true")
			.queryParam("s", "1451613802")
				
			
		  
      .when()
          .get("https://helloacm.com/api/unix-timestamp-converter/");

          int statusCode = res.getStatusCode();
          System.out.println("Response status code: " + statusCode);
          

          String responseBody = res.getBody().asString();
       

          System.out.println("Response body: " + responseBody);
        //  Assert.assertNotNull(responseBody);
         Assert.assertTrue(responseBody.contains("2016-01-01"));
      //  Date date= UnixTimestampConverterTest.testcovert(1451613802);
          Assert.assertTrue(responseBody.contains("false"));
          
          //https://helloacm.com/api/unix-timestamp-converter/?cached&s=1648752000
      }
  
 //In this example, the response object is extracted using RestAssured and the timestamp value is retrieved from the response using JSONPath expression. Then, the SimpleDateFormat class is used to parse and format the timestamp value with the desired format. Finally, the parsed timestamp value is compared with the original timestamp value using assertTrue method to assert that the format is correct.

 
		  
		  
		  
//	import io.restassured.RestAssured;
//	import io.restassured.response.Response;
//
//	public class APIUtilities {
//
//	    public static String getUnixTimestamp(String s) {
//	        String url = "https://helloacm.com/api/unix-timestamp-converter/?cached&s=" + s;
//	        Response response = RestAssured.get(url);
//	        String responseBody = response.getBody().asString();
//	        return responseBody;
//	    }
//	}

		 

		
				
		
		
		
				
				//System.out.println("Status code is:"+ res.statusCode());
				
				
				//System.out.println("Data of get request is:"+ res.asString());
	}

	
	
	


