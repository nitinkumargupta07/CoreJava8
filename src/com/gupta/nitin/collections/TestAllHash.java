package com.gupta.nitin.collections;

import java.util.HashSet;;

public class TestAllHash {
	public static void main(String[] args) {

		// List types -- ArrayList, Vector, LinkedList
		// Set types -- TreeSet, LinkedHashSet, HashSet
		// Map types -- HashMap, Hashtable, LinkedHashMap, TreeMap
		// Queue types -- PriorityQueue

		// Types that require hashCode() -- HashSet, LinkedHashSet, HashMap, Hashtable,
		// LinkedHashMap
		// ArrayList is ordered by index but unsorted by element
		// Vector is a synchronized ArrayList
		// Linked list is ordered by index but the elements are doubly linked (whatever
		// the hell that means)
		// the important thing to remember is that it implements Queue and so has access
		// to peek(), poll() and offer() methods
		// HashSet is an unsorted, unordered set -- so it differs from arraylist in that
		// it is NOT ordered by index AND requires unique elements
		// LinkedHashSet is still unsorted, but it is now ordered -- it is more like an
		// ArrayList that requires unique elements
		// TreeSet is a sorted and ordered set -- it requires unique elements that
		// implement Comparable, or you need to use a constructor that accepts a
		// Comparator
		// HashMap is an unsorted, unordered collection of key value pairs. Maps all
		// allow non-unique elements, but demand unique keys
		// Hashtable is a synchronized HashMap
		// LinkedHashMap is an ordered and sorted BY INSERTION order -- keys and
		// elements do not need to implement comparator or comparable
		// TreeMap is ordered and sorted by natural order or by a Comparator or
		// Comparable
		// PriorityQueue is orered and sorted by Natural order or by a Comparator or
		// Comparable, think of it as a LinkedList that is ordered
		// by priority instead of by insertion order.

		// HashHillBilly correctly overrides hashCode() and equals()
		HashHillBilly a = new HashHillBilly();
		HashHillBilly dupA = new HashHillBilly(a.getName());
		System.out.println(
				"Hashcodes equal? " + (a.hashCode() == dupA.hashCode()) + " Objects equal? " + (a.equals(dupA)));

		// UnHashHillBilly correctly overrides equals() but not hashCode()
		UnHashHillBilly b = new UnHashHillBilly();
		UnHashHillBilly dupB = new UnHashHillBilly(b.getName());
		System.out
				.println("Hashcodes equal? " + (b.hashCode() == dupB.hashCode()) + " Objects equal? " + b.equals(dupB));

		// UnHashUnEqualHillBilly does not override equals() or hashCode()
		UnHashUnEqualHillBilly c = new UnHashUnEqualHillBilly();
		UnHashUnEqualHillBilly dupC = new UnHashUnEqualHillBilly(c.getName());
		System.out
				.println("Hashcodes equal? " + (c.hashCode() == dupC.hashCode()) + " Objects equal? " + c.equals(dupC));

		// now lets try to use each object type in each hash collection type
		// HashSet
		System.out.println("HashSet Tests");
		HashSet<HashHillBilly> hashSetA = new HashSet<HashHillBilly>();
		for (int i = 0; i < 4; i++) {
			hashSetA.add(new HashHillBilly());
		}
		HashSet<UnHashHillBilly> hashSetB = new HashSet<UnHashHillBilly>();
		for (int i = 0; i < 4; i++) {
			hashSetB.add(new UnHashHillBilly());
		}
		HashSet<UnHashUnEqualHillBilly> hashSetC = new HashSet<UnHashUnEqualHillBilly>();
		for (int i = 0; i < 4; i++) {
			hashSetC.add(new UnHashUnEqualHillBilly());
		}
		// The size of the hash collections are determined by the number of unique hash
		// codes in the collection
		// Each hash code works as a bucket storing the objects
		// In the first HashSet the object type properly overrides hashCode to return
		// the length of the String name member
		// There is only a possibility of 3 total hashCodes because there are 4 names,
		// but 2 have the same length
		// In the second and third hashSets, the object type does not properly override
		// hashCode, so each object gets its own bucket
		// This results in a size of 4.
		System.out.println(hashSetA.size() + " " + hashSetB.size() + " " + hashSetC.size());
		// Now we will test finding an element in a hashset
		HashHillBilly myHashA = new HashHillBilly();
		HashHillBilly myHashB = myHashA;
		HashHillBilly myHashDup = new HashHillBilly(myHashA.getName());
		hashSetA.add(myHashA);
		System.out.println("Contains myHashA? " + hashSetA.contains(myHashA) + " Contains myHashB "
				+ hashSetA.contains(myHashB) + " Contains myHashDup? " + hashSetA.contains(myHashDup));
		// Since hashCode is not overridden it can find the first two but not the third!
		// The third is an identical, but duplicate object
		// This means if you didn't have access to the original reference variables you
		// could never retrieve the object!
		UnHashHillBilly myUnHashA = new UnHashHillBilly();
		UnHashHillBilly myUnHashB = myUnHashA;
		UnHashHillBilly myUnHashDup = new UnHashHillBilly(myUnHashA.getName());
		hashSetB.add(myUnHashA);
		System.out.println("Contains myUnHashA? " + hashSetB.contains(myUnHashA) + " Contains myUnHashB "
				+ hashSetB.contains(myUnHashB) + " Contains myUnHashDup? " + hashSetB.contains(myUnHashDup));

		// Same results without equals
		UnHashUnEqualHillBilly myA = new UnHashUnEqualHillBilly();
		UnHashUnEqualHillBilly myB = myA;
		System.out.println("myB equals myA? " + myA.equals(myB));
		UnHashUnEqualHillBilly myADup = new UnHashUnEqualHillBilly(myA.getName());
		hashSetC.add(myA);
		System.out.println("Contains myA? " + hashSetC.contains(myA) + " Contains myB " + hashSetC.contains(myB)
				+ " Contains myADup? " + hashSetC.contains(myADup));
		// LinkedHashSet
		// HashMap
		// HashTable
		// LinkedHashMap

	}
}

// all Hash collections require a class that overrides equals and hashCode
// you do not need to override comparable or create a comparator unless it is a
// sorted collection (Tree or PriorityQueue)
// remember implements Comparable == override compareTo(<T>) implements
// Comparator<T> overrides compare(T a, T b)

class HashHillBilly {
	private String name;

	public String getName() {
		return name;
	}

	HashHillBilly() {
		String[] names = { "Jimbo", "BillyBob", "AnnieSue", "Dolly" };
		int nameNum = (int) (Math.random() * 4);
		name = names[nameNum];
	}

	HashHillBilly(String n) {
		name = n;
	}

	public boolean equals(Object o) {
		if (o instanceof HashHillBilly) {
			return name.equals(((HashHillBilly) o).getName());
		}
		return false;
	}

	public int hashCode() {
		return name.length();
	}
}

class UnHashHillBilly {
	private String name;

	public String getName() {
		return name;
	}

	UnHashHillBilly() {
		String[] names = { "Jimbo", "BillyBob", "AnnieSue", "Dolly" };
		int nameNum = (int) (Math.random() * 4);
		name = names[nameNum];
	}

	UnHashHillBilly(String n) {
		name = n;
	}

	public boolean equals(Object o) {
		if (o instanceof UnHashHillBilly) {
			return name.equals(((UnHashHillBilly) o).getName());
		}
		return false;
	}
}

class UnHashUnEqualHillBilly {
	private String name;

	public String getName() {
		return name;
	}

	UnHashUnEqualHillBilly() {
		String[] names = { "Jimbo", "BillyBob", "AnnieSue", "Dolly" };
		int nameNum = (int) (Math.random() * 4);
		name = names[nameNum];
	}

	UnHashUnEqualHillBilly(String n) {
		name = n;
	}
}