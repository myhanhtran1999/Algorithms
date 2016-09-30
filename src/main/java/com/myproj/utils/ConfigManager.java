package com.myproj.utils;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigManager {  ///src/main/java/com/myproj/configs
	
	private static PropertiesConfiguration prop;
	public static String configPath = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "java" + 
			File.separator + "com" + File.separator + "myproj" + File.separator + "configs" + File.separator;
	
	//Make class as singleton class
	private static ConfigManager instance = null;
	private ConfigManager() {}
	private ConfigManager(String configFileName) {
		try {
			prop = new PropertiesConfiguration(configPath + configFileName);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}
	
	public static ConfigManager getInstance(String configFileName) {
		if (instance == null) {
			instance = new ConfigManager(configFileName);
		}
		return instance;
	}
	
	public void setProp(String key, String value) {
		prop.setProperty(key, value);
	}
	
	public String getValueOf(String key) {
		return prop.getString(key);
	}
	
	public  String[] getValuesOf(String key) {
		return prop.getStringArray(key);
	}
	
	public PropertiesConfiguration getProp() {
		return prop;
	}
}
