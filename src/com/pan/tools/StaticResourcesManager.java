package com.pan.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.pan.db.DataBaseManager;


public abstract class StaticResourcesManager{
    	
	/*
	 * put something common here,such as DB configuration...
	 */
	public static Map<String,String> resources = new HashMap<String,String>();
	
	static {
		InputStream is = DataBaseManager.class.getResourceAsStream("/MysqlConfig.properties");
		Properties pros = new Properties();
		try {
			pros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String dbClassloader=pros.getProperty("className");
		String url = pros.getProperty("url");
		String username = pros.getProperty("username");
		String password = pros.getProperty("password");
		int poolNumber = Integer.parseInt(pros.getProperty("poolnumber"));
			
		putResources("className",dbClassloader);
		putResources("url",url);
		putResources("username",username);
		putResources("password",password);
		putResources("poolNumber",String.valueOf(poolNumber));
	}
	
	public static void putResources(String key,String value){
		resources.put(key, value);
	}
	
	public static String getResources(String key){
		return resources.get(key);
	}
}
