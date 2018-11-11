package com.paniclater.downcast;

import java.util.*;

class Tree {
	String name = "generic tree";

	public String toString() {
		return name;
	}
}

abstract class FruitTree extends Tree {
	static int fruitCount;
	String fruitType;
	String name = "FruitTree";

	abstract void makeFruit();

	public String toString() {
		return name + " Fruit count: " + fruitCount;
	}
}

class AppleTree extends FruitTree {
	static int appleCount;
	String name = "Apple Tree";
	String fruitType = "Apple";

	public String toString() {
		return name + " Apple count: " + appleCount + " Fruit count: " + fruitCount;
	}

	public void makeFruit() {
		++fruitCount;
		++appleCount;
	}
}

class PlumTree extends FruitTree {
	static int plumCount;
	String name = "Plum Tree";
	String fruitType = "Plum";

	public String toString() {
		return name + "Plum count: " + plumCount + " Fruit count: " + fruitCount;
	}

	public void makeFruit() {
		++fruitCount;
		++plumCount;
	}
}

public class TestTrees {
	public static void main(String[] args) {
		AppleTree ap = new AppleTree();
		ap.makeFruit();
		PlumTree pt = new PlumTree();
		pt.makeFruit();
		System.out.println(ap.toString());
		List<FruitTree> trees = new ArrayList<FruitTree>();
		trees.add((FruitTree) ap);
		trees.add(pt);
		for (FruitTree ft : trees) {
			ft.makeFruit();
		}
		System.out.println(ap.toString());
		System.out.println(pt.toString());
		// when accessing member variables directly polymorphism does not apply -- the
		// value returned is determined by reference variable type
		System.out.println(((Tree) ap).name);
		System.out.println(((FruitTree) ap).name);
		System.out.println(((AppleTree) ap).name);
		// when accessing member variables through METHODS polymorphism does apply --
		// the value returned is determined by object instance type
		System.out.println(((Tree) ap).toString());
		System.out.println(((FruitTree) ap).toString());
		System.out.println(((AppleTree) ap).toString());

	}
}
