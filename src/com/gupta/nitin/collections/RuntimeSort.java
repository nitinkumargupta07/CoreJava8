package com.gupta.nitin.collections;
import java.util.*;

public class RuntimeSort {
	public static void main(String[] args) {
		//there are 3 sorted collections to remember for the exam -- TreeMap, PriorityQueue and TreeSet
		//all of the wrapper classes and the string class implement comparable and so work in these sorted sets out of the box.
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		TreeSet<String> ts = new TreeSet<String>();
		PriorityQueue<Double> pq = new PriorityQueue<Double>();
		tm.put(new Integer(8), "Eight");
		tm.put(new Integer(-5), "Negative Five");
		ts.add("Hello");
		ts.add("a");
		pq.add(new Double(56.7));
		pq.add(new Double(.567));

		//in order to use a class that doesn't implement comparable you need to use a comparator. the comparator must be passed
		//to the collection in its constructor
		NameSort ns = new NameSort();
		TreeSet<RunBox> rbSet = new TreeSet<RunBox>(ns);
		TreeMap<RunBox, Integer> rbMap = new TreeMap<RunBox, Integer>(ns);
		//queues continue to be annoying as hell and require an initial capacity along with the comparator
		PriorityQueue<RunBox> rbQueue = new PriorityQueue<RunBox>(10, ns);
		rbSet.add(new RunBox());
		rbSet.add(new RunBox());
		rbMap.put(new RunBox(), new Integer(5));
		rbMap.put(new RunBox(), new Integer(6));
		//you get a class cast exception if you try to add an unsortable item to a sorted collection
		try {
			PriorityQueue<RunBox> pqr = new PriorityQueue<RunBox>();
			pqr.add(new RunBox());
			//Queues continue to be weird as hell, only trying to invoke compareTo if there is more than one element inserted!
			pqr.add(new RunBox());
		} catch (ClassCastException cce) {
			System.out.println("PriorityQueue error " +cce);
		}
		try {
			TreeMap<RunBox, RunBox> tmr = new TreeMap<RunBox, RunBox>();
			tmr.put(new RunBox(), new RunBox());
		} catch (ClassCastException cce) {
			System.out.println("TreeMap error " + cce);
		}
		try {
			TreeSet<RunBox> tsr = new TreeSet<RunBox>();
			tsr.add(new RunBox());
		} catch (ClassCastException cce) {
			System.out.println("TreeSet error " + cce);
		}
		//if the class implements comparable directly there is no need to use a comparator.
		try {
			TreeMap<ComparableBox, ComparableBox> tmcb = new TreeMap<ComparableBox, ComparableBox>();
			tmcb.put(new ComparableBox(), new ComparableBox());
			tmcb.put(new ComparableBox(), new ComparableBox());
		} catch (ClassCastException cce) {
			System.out.println(cce);
		}
		try {
			TreeSet<ComparableBox> tscb = new TreeSet<ComparableBox>();
			tscb.add(new ComparableBox());
			tscb.add(new ComparableBox());
		} catch (ClassCastException cce) {
			System.out.println(cce);
		}
		try {
			PriorityQueue<ComparableBox> pqcb = new PriorityQueue<ComparableBox>();
			pqcb.offer(new ComparableBox());
			pqcb.offer(new ComparableBox());
		} catch (ClassCastException cce) {

		}
		
	}
}


class RunBox {
	private String name;
	public String getName() {
		return name;
	}
	//if you try and add sortable objects that don't have things to sort by you will get a null pointer exception at runtime 
	//when the jvm tries to invoke the comparator's compare to
	RunBox() { name = "Bob"; }
}
class ComparableBox implements Comparable<ComparableBox> {
	private String name;
	public String getName() {
		return name;
	}
	ComparableBox() { name = "Bob"; }
	public int compareTo(ComparableBox cb) {
		return name.compareTo(cb.getName());
	}
}

class NameSort implements Comparator<RunBox> {
	public int compare(RunBox a, RunBox b) {
		return a.getName().compareTo(b.getName());	
	}
}