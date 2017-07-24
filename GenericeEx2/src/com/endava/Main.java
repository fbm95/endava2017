package com.endava;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<String> list2 = new ArrayList<String>();
		list2.add("unu");
		list2.add("doi");
		list2.add("trei");

		printList(list1);
		
		printList(list2);
		
	}

}
