package com.asdco.nas.util;

import javax.json.Json;
import javax.json.JsonReader;

import org.apache.commons.io.IOUtils;

public class JsonUtil {

	public static String toJsonString(Object object){
		return null;
		
	}
	
	public static <T> T fromJsonString(String jsonString, Class<T> expectedClass){
		JsonReader reader = Json.createReader(IOUtils.toInputStream(jsonString));
		return null;
	}
}
