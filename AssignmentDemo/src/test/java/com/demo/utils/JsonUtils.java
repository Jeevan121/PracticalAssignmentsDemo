package com.demo.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.response.Response;

public class JsonUtils {
	
	public  String frameJsonRrquest(HashMap<String, String> map){
		JSONObject obj = new JSONObject();
		obj.putAll(map);
		return obj.toJSONString();
	}
	
	public HashMap<String, String> getJSonRequestMap(String[] keys,String[] values){
		HashMap<String, String> map = new HashMap<String,String>();
		for(int i=0;i<keys.length;i++){
			map.put(keys[i].trim(),values[i].trim());
		}
		return map;
	}
	
	public Map getMapFromJsonObject(JSONObject jsonObj) throws JsonParseException, JsonMappingException, IOException{
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		Map<String, String> reqMap = mapper.readValue(jsonObj.toJSONString(),Map.class);
		return reqMap;
	}
	
	public  JSONObject parseJsonResponse(Response res){
		JSONObject obj = (JSONObject) JSONValue.parse(res.asString());
		return obj;
	}
	
	

}
