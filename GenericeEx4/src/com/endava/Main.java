package com.endava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	private static int count;

	public static void initializeList(List<? super Integer> list) {
		int low = 1;
    	int high = 100;
    	int result;
    	
	    for (int i = 0; i < count; i++) {
	    	Random r = new Random();
	    	result = r.nextInt(high-low) + low;
	        list.add(result);
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		count=10;

		List<Number> list = new ArrayList<Number>();
		
		initializeList(list);
		
		for (int i = 0; i < count; i++) {
			System.out.println(list.get(i));
		}
		
	}

}
