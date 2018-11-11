package com.gupta.nitin.comparing;

import java.util.*;
public class MyCompare implements Comparable<MyCompare> {
	private String name;
	public String getName() {
		return name;
	}
	MyCompare(String name) {
		this.name = name;
	}
	public int compareTo(MyCompare a) {
		return name.compareTo(a.getName());
	}
	public static void main(String[] args) {
		MyCompare a = new MyCompare("Bobby");
		MyCompare b = new MyCompare("Andrea");
		List<MyCompare> list = new ArrayList<MyCompare>();
		list.add(a);
		list.add(b);
		Collections.sort(list);
		for(MyCompare c : list) { System.out.println(c.getName()); }
		Set<MyCompare> t = new TreeSet<MyCompare>();
		t.add(a);
		t.add(b);
		for(MyCompare c : t) { System.out.println(c.getName()); }
	}	
}