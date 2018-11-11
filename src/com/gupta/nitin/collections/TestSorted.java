package com.gupta.nitin.collections;

import java.util.*;

public class TestSorted {
	public static void main(String[] args) {
		// There are 3 ordered collections on the exam: TreeMap, TreeSet and Priority
		// Queue
		Map<Human, Ewok> map = new TreeMap<Human, Ewok>();
		Set<Human> set = new TreeSet<Human>();
		Queue<Human> queue = new PriorityQueue<Human>();

		map.put(new Human("Fred", "Blue"), new Ewok("Wicket", "Brown"));
		map.put(new Human("Sally", "Brown"), new Ewok("Jicket", "Brown"));
		for (Human h : map.keySet())
			System.out.println(h.toString());
		set.add(new Human("Fred", "Blue"));
		set.add(new Human("Sally", "Brown"));
		for (Human h : set)
			System.out.println(h.toString());
		queue.add(new Human("Fred", "Blue"));
		queue.add(new Human("Sally", "Brown"));
		for (Human h : queue)
			System.out.println(h.toString());

		Queue<Ewok> brokenQ = new PriorityQueue<Ewok>();
		Set<Ewok> brokenS = new TreeSet<Ewok>();
		Map<Ewok, Human> brokenM = new TreeMap<Ewok, Human>();
		try {
			brokenQ.add(new Ewok("Wicket", "Brown"));
			brokenQ.add(new Ewok("Jicket", "Brown"));
			for (Ewok e : brokenQ)
				System.out.println(e.toString());
		} catch (ClassCastException cce) {
			System.out.println(cce);
		}
		try {
			brokenS.add(new Ewok("Wicket", "Brown"));
			brokenS.add(new Ewok("Jicket", "Brown"));
			for (Ewok e : brokenS)
				System.out.println(e.toString());
		} catch (ClassCastException cce) {
			System.out.println(cce);
		}
		try {
			brokenM.put(new Ewok("Wicket", "Brown"), new Human("Jicket", "Brown"));
			brokenM.put(new Ewok("Wicket", "Brown"), new Human("Jicket", "Brown"));
			for (Ewok e : brokenM.keySet())
				System.out.println(e.toString());
		} catch (ClassCastException cce) {
			System.out.println(cce);
		}
		System.out.println(
				"You can only succesfully add objects to sorted collections -- PriorityQueue, TreeMap and TreeSet -- if they implement comparable or have a comparator");
	}
}

class Human implements Comparable<Human> {
	String name;
	String eyeColor;

	@Override
	public String toString() {
		return "Human [name=" + name + ", eyeColor=" + eyeColor + "]";
	}

	public String getName() {
		return name;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	Human(String name, String eyeColor) {
		this.name = name;
		this.eyeColor = eyeColor;
	}

	public int compareTo(Human other) {
		return name.compareTo(other.getName());
	}
}

class SortByEyeColor implements Comparator<Human> {
	public int compare(Human a, Human b) {
		return a.getEyeColor().compareTo(b.getEyeColor());
	}
}

class Ewok {
	String name;
	String eyeColor;

	@Override
	public String toString() {
		return "Ewok [name=" + name + ", eyeColor=" + eyeColor + "]";
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public String getName() {
		return name;
	}

	Ewok(String name, String eyeColor) {
		this.name = name;
		this.eyeColor = eyeColor;
	}
}