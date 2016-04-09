package com.asdco.nas.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;



public class JsonUtil {

	public static String toJsonString(Object object){
		
		return null;
		
	}
	
	public static <T> T fromJsonString(String jsonString, Class<T> expectedClass){
        byte[] jsonData = jsonString.getBytes();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        T object;
        try {
       	object = objectMapper.readValue(jsonData, expectedClass);
			return object;
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		
		
		
		
	}
}
