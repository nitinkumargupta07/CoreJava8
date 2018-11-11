package com.paniclater.generics;

import java.util.*;

public class GenericMethods {
	
	public static void main(String[] args) {
	X x = new X();
	x.xSaysHi(new Object());
	x.xSaysHiAgain(new Object());	
	}
	
}


class X {
	//when you are declaring a method that uses a generic type not declared by the class you must declare the type
	//after the access modifier but before the return type. You can then reference the type in the argument list and the method.
	public <A> void xSaysHi(A a) {
		List<A> list = new ArrayList<A>();
		list.add(a);
		for(A myA : list) { System.out.println(myA.toString()); }
	}
	//You can basically define these types on the fly!
	public <Animals> void xSaysHiAgain(Animals a) {
		List<Animals> list = new ArrayList<Animals>();
		list.add(a);
	}
}
