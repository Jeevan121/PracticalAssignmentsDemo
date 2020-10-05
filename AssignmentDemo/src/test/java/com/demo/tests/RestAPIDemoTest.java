package com.demo.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.AutomationConstants;
import com.demo.utils.BaseTest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.response.Response;

public class RestAPIDemoTest extends BaseTest{
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="RestAPIDemoTest",enabled=true,alwaysRun=true)
	public void restAPIDemoTest(String empNme,String	empId){
		
		Response res=getRestAssuredUtils().getRequest(AutomationConstants.restApiEndPoint+AutomationConstants.apiEmpResource);
		Assert.assertEquals(res.getStatusCode(),200,"not connected to to server");
		
		Reporter.log("the response status code::"+res.getStatusCode());
		Reporter.log("the response of the get request is::"+res.asString());
		
		System.out.println(res.asString());
		
		JSONObject jsonObj = getJsonUtils().parseJsonResponse(res);
		
		//validating the response status against with test input data
		String status = jsonObj.get("status").toString();
		Reporter.log("the response status::"+status);
		Assert.assertEquals(status, "success","the status is not matching");
		
		
		//parsing the array of json data json object and addign into the lists
		JSONArray Jarry = (JSONArray) jsonObj.get("data");
		ArrayList<String> eNameLst = new ArrayList<String>();
		ArrayList<String> idLst = new ArrayList<String>();
		
		for(int i=0;i<Jarry.size();i++){
			JSONObject nn = (JSONObject) Jarry.get(i);
			eNameLst.add(nn.get("employee_name").toString());
			idLst.add(nn.get("id").toString());
		}

		//Validating the employee name and employee id against test input data
		String[] empName = empNme.split(",");
		String[] empID = empId.split(",");
		for(int i=0;i<empName.length;i++){
			Assert.assertEquals(eNameLst.get(i), empName[i].trim(),"The Actual Employee name is "+eNameLst.get(i)+" not matching with Expected"+" "+empName[i].trim());
			Assert.assertEquals(idLst.get(i), empID[i].trim(),"The Actual Employee ID is "+idLst.get(i)+" not matching with Expected"+" "+empID[i].trim());

		}
		
		
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="PostRestAPIDemo",enabled=true,alwaysRun=true)
	public void postRestAssured(String keys,String	values) throws JsonParseException, JsonMappingException, IOException{
		
		//Framing the Json Request Object and getting keys and values from the test input data from excel file
		HashMap<String,String> jsonRequestMap = getJsonUtils().getJSonRequestMap(keys.split(","), values.split(","));
		
		// Framing the Json object with the HashMap
		String framedJsonRequest = getJsonUtils().frameJsonRrquest(jsonRequestMap);
		//Hitting to the Server with Rest Assured Libararies and passing end point, json request file as string and then resource 
		Response res=getRestAssuredUtils().restAssuredPost(AutomationConstants.restApiEndPoint,framedJsonRequest,AutomationConstants.apiEmpCreate);
		Reporter.log("the response of the get request is::"+res.asString());
		
		//Validating the status code should be 200
		Assert.assertEquals(res.getStatusCode(), 200,"the status code is not matching");
		Reporter.log("the responce code"+res.getStatusCode());

		//JSONObject jsonObj = (JSONObject) JSONValue.parse(res.asString());
		JSONObject jsonObj = getJsonUtils().parseJsonResponse(res);
		//validating the response status against with test input data
		String status = jsonObj.get("status").toString();
		Assert.assertEquals(status, "success","the status is not matching");
		
		//Validating the Json Response Against Framed Json hash map
		JSONObject dataJsonObj=  (JSONObject) jsonObj.get("data");
		
		//get the response from the data json object
		Map resMap = getJsonUtils().getMapFromJsonObject(dataJsonObj);
		
		
		// validating the json request map against response map
		Assert.assertEquals(resMap.get("name"),jsonRequestMap.get("name"),"names are not matching");
		Assert.assertEquals(resMap.get("salary"),jsonRequestMap.get("salary"),"names are not matching");
		Assert.assertEquals(resMap.get("age"),jsonRequestMap.get("age"),"names are not matching");
		
		//validating the message
		Assert.assertEquals(jsonObj.get("message"), "Successfully! Record has been added.","record is not created");
		
		
		
	}

}
