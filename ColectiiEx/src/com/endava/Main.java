package com.endava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		String text = "unu unu doi trei patru patru patru";
		Set<String> duplicates = duplicateWords(text);
		Set<String> distincts = distinctWords(text);
		List<String> sorted = sortWords(text);
		HashMap<String, Integer> frequencyTable = getFrequency(text);
		TreeMap<String, Integer> sortedFrequencyTable = getSortedFrequency(text);
		LinkedHashMap<String, Integer> insertFrequency = getInsertFrequency(text);

		System.out.println("input : " + text + "\n");
		System.out.println("duplicates : " + duplicates + "\n");
		System.out.println("distincts : " + distincts + "\n");
		System.out.println("sorted : " + sorted + "\n");
		System.out.println("frequency table: ");
		for (Entry<String, Integer> pair : frequencyTable.entrySet()) {
			// iterate over the pairs
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
		System.out.println(" ");

		System.out.println("sorted frequency table: ");
		for (Entry<String, Integer> pair : sortedFrequencyTable.entrySet()) {
			// iterate over the pairs
			System.out.println(pair.getKey() + " " + pair.getValue());
		}

		System.out.println(" ");

		System.out.println("insert order frequency table: ");
		for (Entry<String, Integer> pair : insertFrequency.entrySet()) {
			// iterate over the pairs
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
	}

	public static Set<String> duplicateWords(String input) {
		if (input == null || input.isEmpty()) {
			return Collections.emptySet();
		}
		Set<String> duplicates = new HashSet<>();
		String[] words = input.split(" ");
		Set<String> set = new HashSet<>();
		for (String word : words) {
			// daca nu putem adauga un element in set ( pentru ca el deja exista
			// )
			// il adaucam in set-ul de du[licate
			if (!set.add(word)) {
				duplicates.add(word);
			}
		}
		return duplicates;
	}

	public static Set<String> distinctWords(String input) {
		if (input == null || input.isEmpty()) {
			return Collections.emptySet();
		}
		Set<String> duplicates = new HashSet<>();
		String[] words = input.split(" ");
		Set<String> distincts = new HashSet<>();
		for (String word : words) {
			// daca nu putem adauga un element in set ( pentru ca el deja exista
			// )
			// il adaucam in set-ul de du[licate
			if (!distincts.add(word)) {
				duplicates.add(word);
			}
		}

		for (String string : duplicates) {
			distincts.remove(string);
		}
		return distincts;
	}

	public static List<String> sortWords(String input) {
		if (input == null || input.isEmpty()) {
			return Collections.emptyList();
		}
		String[] words = input.split(" ");

		Arrays.sort(words);

		List<String> sorted = new ArrayList<String>();

		for (String string : words) {
			sorted.add(string);
		}

		return sorted;
	}

	public static HashMap<String, Integer> getFrequency(String input) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String[] words = input.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			Integer val = map.get(word);

			if (val != null) {
				map.put(word, new Integer(val + 1));
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}

	public static TreeMap<String, Integer> getSortedFrequency(String input) {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		String[] words = input.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			Integer val = map.get(word);

			if (val != null) {
				map.put(word, new Integer(val + 1));
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}

	public static LinkedHashMap<String, Integer> getInsertFrequency(String input) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

		String[] words = input.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			Integer val = map.get(word);

			if (val != null) {
				map.put(word, new Integer(val + 1));
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}

}
