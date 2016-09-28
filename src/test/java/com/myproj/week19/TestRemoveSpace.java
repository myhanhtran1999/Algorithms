package com.myproj.week19;

import java.util.Arrays;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myproj.week26.RemoveSpace;

public class TestRemoveSpace {
	
	RemoveSpace removeSpace;
	
	@BeforeMethod
	public void setup() {
		removeSpace = new RemoveSpace();
	}
	
	@Test
	public void testRemoveSpace() {
		
		String[] list = {"myhanh", "  ", "hien"};
		System.out.println("Original: " + Arrays.toString(list));
		System.out.println("After remove: " + Arrays.toString(removeSpace.removeSpace(list)));
	}

}
