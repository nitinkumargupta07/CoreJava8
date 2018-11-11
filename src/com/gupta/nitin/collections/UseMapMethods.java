package com.gupta.nitin.collections;
import java.util.*;

public class UseMapMethods {
	public static void main(String[] args) {
		TreeMap<Integer, String> myMap = new TreeMap<Integer, String>();
		myMap.put(new Integer(1), "One");
		myMap.put(new Integer(-1), "Negative One");
		myMap.put(new Integer(3), "Three");
		myMap.put(new Integer(5), "TwintyFive");
		//use code that demonstrates the following methods
		//higherKey - returns the lowest key greater than key
		System.out.println("higherKey");
		System.out.println(myMap.higherKey(new Integer(1)));
		System.out.println(myMap.higherKey(new Integer(-1)));
		System.out.println(myMap.higherKey(new Integer(-5)));
		//ceilingKey - returns the lowest key greater than or equal to key
		System.out.println("ceilingKey");
		System.out.println(myMap.ceilingKey(new Integer(2)));
		System.out.println(myMap.ceilingKey(new Integer(1)));
		System.out.println(myMap.ceilingKey(new Integer(-1)));
		System.out.println(myMap.ceilingKey(new Integer(-5)));
		//floorKey - returns the highest key less than or equal to key
		System.out.println("floorKey");
		System.out.println(myMap.floorKey(new Integer(2)));
		System.out.println(myMap.floorKey(new Integer(1)));
		System.out.println(myMap.floorKey(new Integer(-1)));
		//no error even though it can't find anything, just returns null
		System.out.println(myMap.floorKey(new Integer(-5)));
		//firstKey
		System.out.println("firstKey");
		System.out.println(myMap.firstKey());
		System.out.println("lastKey");
		System.out.println(myMap.firstKey());
		
		//tailMap(k, b) returns a subset starting at and inclusive of key k. the boolean is optional and specifies whether the endpoint is inclusive
		
	}

}