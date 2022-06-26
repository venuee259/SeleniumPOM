package com.automation.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	static FileInputStream fis;
	static Properties prop;
	static File file;
	static ObjectMapper mapper;
	static TypeReference<Map<String,String>> mapTypeReference;
	static Map<String,String> map;
	static {
		try {
			file = new File("data.JSON");
			//file = new File(System.getProperty("user.dir")+"data.properties");
			mapper = new ObjectMapper();
			mapTypeReference = new TypeReference<Map<String,String>>(){};
			map  = mapper.readValue(file, mapTypeReference);
			fis = new FileInputStream("data.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static String getDatafromPropertiesFile(String key){
	
	String value="";
	if(prop.contains(key)){
		return prop.getProperty(key);
	}
	
	return value;
	
}


public static String getDatafromJSONFile(String key){
	
	String value="";
	if(map.containsKey(key)){
		return map.get(key);
	}
	
	return value;
	
}


}
