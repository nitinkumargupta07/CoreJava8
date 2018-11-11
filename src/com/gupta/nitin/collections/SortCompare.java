package com.gupta.nitin.collections;

import java.util.*;

public class SortCompare {
	public static void main(String[] args) {
		String[] strings = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };
		Arrays.sort(strings);
		for (int i = 0; i < strings.length; i++)
			System.out.println(strings[i]);
		// binary search will print out the index of the element if it finds it
		System.out.println(Arrays.binarySearch(strings, "three"));
		// it will print out the negative index of where the element should be minus one
		// if it doesn't find it
		// i.e. if it was supposed to be 8 it will print out -9
		System.out.println(Arrays.binarySearch(strings, "tfn"));
		// you can sort an array with a comparator
		CompareLength compareLength = new CompareLength();
		Arrays.sort(strings, compareLength);
		for (int i = 0; i < strings.length; i++)
			System.out.println(strings[i]);
		// then you need to pass the comparator to binarysearch to get accurate results
		// this one is screwy because the comparator sorts by length and several strings
		// have equal lengths.
		// I will have to ask stack overflow about this.
		System.out.println(Arrays.binarySearch(strings, "three", compareLength));
		System.out.println(Arrays.binarySearch(strings, "seven", compareLength));
		System.out.println(strings[7]);
		// if you try to binary search the array without the proper comparator it won't
		// be able to find the element,
		// the most likely result is -1
		System.out.println(Arrays.binarySearch(strings, "three"));
		System.out.println(Arrays.binarySearch(strings, "one"));
		// but results are unpredicatable
	}
}

class CompareLength implements Comparator<String> {
	public int compare(String a, String b) {
		return ((Integer) a.length()).compareTo(b.length());
	}
}