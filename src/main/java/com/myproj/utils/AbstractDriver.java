package com.myproj.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AbstractDriver {
	
	private static IOSDriver iosDriver;
	private static AndroidDriver androidDriver;
	private static ConfigManager configManager;
	
	private static final String IOS_PROPERTIES = "ios.properties";
	private static final String ANDROID_PROPERTIES = "android.properties";
	private static final String SERVER_PROPERTIES = "server.properties";
	
	public enum Platform {
		IOS (IOS_PROPERTIES),
		ANDROID (ANDROID_PROPERTIES),
		SERVER (SERVER_PROPERTIES);
		
		private String configFileName;
		private Platform(String configFileName) {
			this.configFileName = configFileName;
		}
	}
	
	public AbstractDriver() {}
//	public AbstractDriver(String configFileName) {
//		configManager = ConfigManager.getInstance(configFileName);
//	}
	
	
	public void setIOSDriver(IOSDriver driver) {
		iosDriver = driver;
	}
	
	public void setAndroidDriver(AndroidDriver driver) {
		androidDriver = driver;
	}
	
	public static IOSDriver getIOSDriver() {
		try {
			iosDriver = new IOSDriver(getServerURL(), buildCapability());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iosDriver;
	}
	
	public static AndroidDriver getAndroidDriver() {
		try {
			androidDriver = new AndroidDriver(getServerURL(), buildCapability());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return androidDriver;
	}
	
	public static URL getServerURL() throws MalformedURLException {
		configManager = ConfigManager.getInstance(Platform.SERVER.configFileName);
		URL url = new URL("http://" + configManager.getValueOf("LOCAL_HOST") + ":" + configManager.getValueOf("PORT_NO") + "/wd/hub");
		return url;
	}
	
//	public static void main(String[] args) {
//		
//		configManager = ConfigManager.getInstance(Platform.SERVER.configFileName);
//		String url = "http://" + configManager.getValueOf("LOCAL_HOST") + ":" + configManager.getValueOf("PORT_NO") + "/wd/hub";
//		System.out.println("url: " + url);
//	}
	
	@SuppressWarnings("unchecked")
	public static DesiredCapabilities buildCapability() {
		DesiredCapabilities capability = new DesiredCapabilities();
		Iterator<String> keys = configManager.getProp().getKeys();
		while (keys.hasNext()) {
			String key = keys.next();
			capability.setCapability(key, configManager.getValueOf(key));
		}
		return capability;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		configManager = ConfigManager.getInstance(Platform.IOS.configFileName);
		DesiredCapabilities capability = new DesiredCapabilities();
		Iterator<String> keys = configManager.getProp().getKeys();
		while (keys.hasNext()) {
			String key = keys.next();
			//capability.setCapability(key, configManager.getValueOf(key));
			System.out.println(key + " : " + configManager.getValueOf(key));
		}
	}

}
