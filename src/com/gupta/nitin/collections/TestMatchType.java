package com.gupta.nitin.collections;
import java.util.*;

public class TestMatchType {
	public static void main(String[] args) {
		//Sets are collections that maintain unique elements, they are not indexed.
		//If you try to add a non-unique member to a set the method will return false. No exception or compilation errors
		Set<String> stringSet;
		//HashSets are sets that are organized by hash codes. In order to properly use a HashSet equals() and hashCode() must be
		//properly overridden. If you do not override hashCode() then every element in the set will be put into its own "bucket"
		//if you do not override / implement equals then there wil be no way to retrieve an element from the set by passing in a duplicate
		//of the element.
		stringSet = new HashSet<String>();
		//LinkedHashSets are the same as HashSets except their elements are linked together, this makes it an ordered set and also makes
		//it possible to consistently iterate through the set in the order that elements were inserted
		stringSet = new LinkedHashSet<String>();
		//A TreeSet is a sorted collection that guarantees that its elements will be sorted by natural order. If elements are not possible to be sorted
		//by natural order then they must implement comparable or use a comparator. Otherwise you will run into a runtime error when the
		//unsortable element is added to the collection
		stringSet = new TreeSet<String>();
		//Lists are the simplest of collections for me to understand. They function just like arrays on steroids, elements can be added
		//or removed on the fly, length can expand and contract, etc. They are all indexed and ordered.
		List<String> stringList;
		//ArrayList is the go to collection when you don't have specific needs.
		stringList = new ArrayList<String>();
		//Vector is just like array list except it is thread safe. It is generally slower to use b/c of this.
		stringList = new Vector<String>();
		//LinkedLists are ordered by index position just like ArrayLists, but the elements are doubly linked to each other, which allows for methods to 
		//easily add or remove elements from the beginning or end. It implements Queue interface and so it has peek(), poll() and offer()
		stringList = new LinkedList<String>();
		//Maps are similar to sets in that they care about uniqueness, whereas while a Set cares about unique elements a map cares about unique keys.
		//I think about this as a typical array that substitutes a unique key for the integer.
		Map<String, String> stringMap;
		//HashMaps are unsorted and unordered. Fast. Can have only one null key and multiple null values
		stringMap = new HashMap<String, String>();
		//TreeMaps are sorted, ordered collections. 
		stringMap = new TreeMap<String, String>();
		//hashtable is just like a hashmap except it is threadsafe.
		stringMap = new Hashtable<String, String>();
		//Just like a HashMap except ordered by insertion.
		stringMap = new LinkedHashMap<String, String>();
		//This has been the collection that trips me up the most -- or rather the interface. Remember that PriorityQueue,
		//LinkedList and LinkedHAshSet all implement the Queue interface and have access to peek(), poll() and offer() methods
		Queue<String> stringQueue;
		stringQueue = new PriorityQueue<String>();
	}
}