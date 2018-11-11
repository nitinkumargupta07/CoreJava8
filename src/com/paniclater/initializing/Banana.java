package com.paniclater.initializing;
//Important to remember the order
//1. when the first reference occurs all the static init blocks of the superclasses of the class run, followed by their subclasses until the static init blocks of the referenced class are run
//2. Upon instatiation first super is called up the chain to the top superclass(object)
//3. Then instance init blocks followed by constructors run for each class down to the referenced class -- i.e. once we get to the referenced class 
//its instance init blocks run followed by its constructor. 
//4. Then the following lines of code in main are executed in that order.
class Fruit {
	static { System.out.println("Superclass static init"); }
	{ System.out.println("Superclass instance init"); }
	Fruit() {
		System.out.println("Superclass constructor");
	}
}

public class Banana extends Fruit {
	static { System.out.println("Subclass static init"); }
	{ System.out.println("Subclass instance init"); }
	Banana() {
		System.out.println("Subclass constructor");
	}
	public static void main(String[] args) {
		new Banana();
	
	}
}