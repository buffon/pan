package com.pan.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.pan.db.DataBaseManager;

public abstract class InterManager {
	
	public static String currentLanguage = null;
	public static  Properties pros = null;
	
	static {
		InputStream is = DataBaseManager.class.getResourceAsStream("/inter.properties");
		pros = new Properties();
		try {
			pros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		currentLanguage = pros.getProperty("currentLanguage");
	}
	
	public static String getPageResource(String key){
		String interKey = key+currentLanguage;
		return pros.getProperty(interKey);
	}
}
