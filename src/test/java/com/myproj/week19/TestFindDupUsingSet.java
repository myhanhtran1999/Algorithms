package com.myproj.week19;

import org.testng.annotations.Test;
import java.util.Arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFindDupUsingSet {
	
	FindDupUsingSet findDupUsingSet;
	
	@BeforeMethod
	public void setup() {
		findDupUsingSet = new FindDupUsingSet();
	}
	

	@Test
	public void testFindDupUsingSet() {
		String[] list = {"myhanh", "hien", "travis", "tyler", "myhanh"};
		System.out.println("Origin: " + Arrays.toString(list));
		System.out.println("is dup: " + findDupUsingSet.isDupUsingSet(list));
	}

}
