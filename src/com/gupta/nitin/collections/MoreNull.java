package com.gupta.nitin.collections;

import java.util.*;

public class MoreNull {
	public static void main(String[] args) {
		new NullSets();
	}

}

class NullSets {

	NullSets() {
		Set<String> hs = new HashSet<String>();
		Set<String> ls = new LinkedHashSet<String>();
		Set<String> ts = new TreeSet<String>();
		// Sets do not allow duplicate items -- more than one of the same element cannot
		// be added. There is no compiler error or exception.
		// add() simply returns false and the element isn't added.
		hs.add(null);
		hs.add("A");
		hs.add("B");
		hs.add("C");
		hs.add("D");
		hs.add(null);
		hs.add(null);
		hs.add("D");
		System.out.print("HashSet: ");
		for (String s : hs)
			System.out.print(s + " ");
		ls.add(null);
		ls.add("A");
		ls.add("B");
		ls.add("C");
		ls.add("D");
		ls.add(null);
		ls.add("D");
		System.out.print("\nLinkedSet: ");
		for (String s : ls)
			System.out.print(s + " ");
		// if you try and add a null item to a sorted collection (TreeSet, TreeMap,
		// PriorityQueue), then the set will try to set it and there will be a null
		// pointer exception.
		// ts.add(null);
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		///ts.add(null); //NullPointerException
		ts.add("d");
		ts.add("D");
		System.out.print("\nTreeSet: ");
		for (String s : ts)
			System.out.print(s + " ");
	}

}

class NullMaps {
	NullMaps() {
		Map<String, String> hm = new HashMap<String, String>();
		Map<String, String> ht = new Hashtable<String, String>();
		Map<String, String> lm = new LinkedHashMap<String, String>();
		Map<String, String> tm = new TreeMap<String, String>();
	}

}

class NullLists {
	NullLists() {
		List<String> ll = new LinkedList<String>();
		List<String> al = new ArrayList<String>();
		List<String> v = new Vector<String>();
	}
}

class NullQueue {
	NullQueue() {
		Queue<String> q = new PriorityQueue<String>();
	}
}