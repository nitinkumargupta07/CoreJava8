package com.paniclater.generics;

import java.util.*;

class Sandwich {
	String bread;

	public String getBread() {
		return bread;
	}

	Sandwich(String bread) {
		this.bread = bread;
	}

	Sandwich() {
		this.bread = "White";
	}
}

class Reuben extends Sandwich {
	Reuben() {
		super("Rye");
	}
}

class Burger extends Sandwich {
	Burger(String s) {
		super(s);
	}

	Burger() {
		super("bun");
	}
}

class SandwichList<T extends Sandwich> {
	private List<T> myList = new ArrayList<T>();

	SandwichList(T[] t) {
		myList = Arrays.asList(t);
	}
}

class CompareBread<T extends Sandwich> implements Comparator<T> {
	// remember Comparator overrides compare(object a, object b)
	// comparable overrides compareTo(object a)
	// a good way to remember this is that compare takes two objects, but String
	// uses compareTo and already implements it.
	public int compare(T a, T b) {
		return a.getBread().compareTo(b.getBread());
	}
}

public class TestCustom {
	public static void main(String[] args) {
		Queue<Sandwich> orders = new PriorityQueue<Sandwich>();
		orders.add(new Sandwich());
		orders.add(new Sandwich("Baguette"));
		orders.add(new Sandwich("Pumpernickel"));
		Sandwich[] ordersArray = orders.toArray(new Sandwich[orders.size()]);

		SandwichList<Sandwich> mySammies = new SandwichList<Sandwich>(ordersArray);

	}
}
