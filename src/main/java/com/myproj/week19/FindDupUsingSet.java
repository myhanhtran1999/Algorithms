package com.myproj.week19;

import java.util.HashSet;
import java.util.Set;

public class FindDupUsingSet {
	
	public boolean isDupUsingSet(String[] list) {
		
		boolean status = false;
		Set<String> set = new HashSet<String>();
		for (String item : list) {
			if (!set.add(item)) {
				status = true;
				break;
			}
		}
		return status;
	}

}
