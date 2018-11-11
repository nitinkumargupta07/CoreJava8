package com.gupta.nitin.collections;

import java.util.*;

public class NullMap {
	public static void main(String[] args) {
		Map<String, String> testMap = new HashMap<String, String>();
		String[] keys = { null, "", "1", "2", null, "B" };
		String[] values = { "lost", null, null, null, "found", null };
		for(int i = 0; i < keys.length; i++) {
			testMap.put(keys[i], values[i]);
		}
		//testMap's size will be 5 because map only allows 1 null key but many null values
		//this means that when the iteration reaches the second null in the keys array instead of creating a new element, it just stuffs
		//the corresponding value into the old key and we lose the old element.
		System.out.println(testMap.size());
		//as predicted this will print "found" not "lost"
		System.out.println(testMap.get(null));
	}
}