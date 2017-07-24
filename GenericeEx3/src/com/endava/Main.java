package com.endava;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static double sumOfList(List<? extends Number> list) {
	    double s = 0.0;
	    for (Number n : list)
	        s += n.doubleValue();
	    return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Double> list2 = new ArrayList<Double>();
		list2.add(1.2);
		list2.add(1.3);
		list2.add(1.4);

		System.out.println(sumOfList(list1));
		
		System.out.println(sumOfList(list2));
		
	}

}
