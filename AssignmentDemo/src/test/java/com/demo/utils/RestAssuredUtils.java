package com.demo.utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {
	Response response;
	public Response getRequest(String endPoint){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		response=httpRequest.request(Method.GET);
		return response;
	}
	
	public Response restAssuredPost(String baseUrl,String jsonRequest,String resourceName){
		RestAssured.baseURI=baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonRequest);
		Response res = httpRequest.post(resourceName);
		return res;
		
		
	}

}
