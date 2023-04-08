package com.APIEpocCovereter.teststeps;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class httpmethods {
	Properties pr;
	
	public httpmethods(Properties pr)
	{
		this.pr=pr;
	}
	
	
	
	public Response getrequest(String urikey)
	{
		//urikey=baseurl
		//endpoint= query/path parameter  baseurl?id="" or baseurl/id=""
		
		
		Response res=
				given()
			
//			.queryParam("cached",1)
//			.queryParam("s", timestamp)						  
            .when()
            .get(pr.getProperty(urikey));

               
		
		
		
	  System.out.println("Response code is"+res.statusCode());
	  System.out.println("Response is"+res.asString());
		  
		return res;
		
	}
	
	public Response invalid_getrequest(String urikey)
	{
		//urikey=baseurl
		//endpoint= query/path parameter  baseurl?id="" or baseurl/id=""
		
		
		Response res=
				given()
			
//			.queryParam("cached","true")
//			.queryParam("s", "timestamp")						  
            .when()
            .get(pr.getProperty(urikey));

           
		
		
		  System.out.println("Response code is"+res.statusCode());
		  System.out.println("Response is"+res.asString());
		  
		return res;
		
	}
	
	public Response getrequest_invalid(String urikey, String timestamp)
	{
		//urikey=baseurl
		//endpoint= query/path parameter  baseurl?id="" or baseurl/id=""
		
		
		Response res=
				given()
			.queryParam("cached","true")
			.queryParam("s","timestamp")						  
            .when()
            .get(pr.getProperty(urikey));

               
		
		
		
	  System.out.println("Response code is"+res.statusCode());
	  System.out.println("Response is"+res.asString());
		  
		return res;
		
	}
	public Response getrequest_futuredate(String urikey)
	{
		//urikey=baseurl
		//endpoint= query/path parameter  baseurl?id="" or baseurl/id=""
		//String baseurl=pr.getProperty(urikey);
		//String uri= baseurl+"/"+endpoint;
		
		  Response res=
		given()
	//	.contentType(ContentType.JSON)
		.when()
		.get(pr.getProperty(urikey));
		  
		  System.out.println("Response code is"+res.statusCode());
		  System.out.println("Response is"+res.asString());
		
		 return res;
		
	}
	
	public Response putrequest(String jsonrequestbody,String urikey,String pathparameter)
	{
		String uri=pr.getProperty(urikey)+"/"+pathparameter;
	  Response res=
	   given()
	  .contentType(ContentType.JSON)
	  .body(jsonrequestbody)
	  .when()
	  .put(uri);
	  
	  System.out.println("Response code is"+res.statusCode());
	  System.out.println("Response is"+res.asString());
	  return res;
		
	}
	
	public Response deleterequest(String urikey, String pathparamter)
	{
		//urikey=baseurl
		//endpoint= query/path parameter  baseurl?id="" or baseurl/id=""
		String baseurl=pr.getProperty(urikey);
		String uri= baseurl+"/"+pathparamter;
		
		  Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete(uri);
		  
		  System.out.println("Response code is"+res.statusCode());
		  System.out.println("Response is"+res.asString());
		
		 return res;
		
	}
	
	
	
	public Response getRequest(String baseUrl, java.util.Map<String, String> queryParams)
	{
	    io.restassured.specification.RequestSpecification requestSpec = given().baseUri(baseUrl);
	    for (java.util.Map.Entry<String, String> entry : queryParams.entrySet()) {
	        requestSpec.queryParam(entry.getKey(), entry.getValue());
	    }
	    Response response = requestSpec.when().get();
	    return response;
	}
}
