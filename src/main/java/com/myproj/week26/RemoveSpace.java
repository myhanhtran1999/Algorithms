package com.myproj.week26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RemoveSpace {
	
	public static void main(String[] args) {
		
		String[] list = {"myhanh", "  ", "Hien"};
		System.out.println("Before: " + Arrays.toString(list));
		System.out.println("After remove: " + Arrays.toString(removeSpace(list)));
	}
	
	private static String[] removeSpace(String[] list) {
		
		// Replace multiple sequencial space
		
		// Convert String[] to ArrayList
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(list));
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().replaceAll("\\s+", " ").equals(" ")) {
				iterator.remove();
			}
		}
		return arrayList.toArray(new String[arrayList.size()]);		
	}

}
