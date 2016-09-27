package com.myproj.week26;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDupUsingHashMap {
	
	public static void main(String[] args) {
		
		//String[] list = {"one", "two", "three", "two", "three", "four", "five", "six", "one"};
		String[] list = {"one", "two", "three"};
		boolean status = findDupUsingHashMap(list);
		System.out.println("status" + status);
		if (status == true) {
			System.out.println("The list has dup");
		} else {
			System.out.println("The list has NO DUP");
		}
	}
	
	private static boolean findDupUsingHashMap(String[] list) {
		
		boolean status = false;
		Map<String, Integer> map = new HashMap<String, Integer>();
		// Build the hashmap table
		for (String item : list) {
			map.put(item, map.get(item) == null ? 1 : map.get(item) + 1);
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				status = true;
				System.out.println(entry.getKey() + " is dup " + entry.getValue() + " times");
			} 
		}
		return status;
	}
	

}
