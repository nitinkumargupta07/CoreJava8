package com.paniclater.polymorphism;

import java.util.ArrayList;

class A {
}

class B extends A {
}

public class Casting {
	void go(B b) {
		System.out.println("I worked");
	}

	void test(A a) {
		System.out.println("I worked super");
	}
	static Object stop(ArrayList[] a) {
		System.out.println("I worked");
		return a;
	}
	
	public static void main(String[] args) {
		Casting c = new Casting();
		// c.go(new A()); super class not allow
		c.go((B) new A()); // down casting is explicit
		B b = new B();
		c.test(b);
		Object m = b;
		// without a cast down the following invocation will fail -- only
		// reference variables of type B or subtypes of B will be allowed by the
		// compiler
		// even if the variable is not of type B but the object instance is.
		c.go((B) m);
	}

	
}
