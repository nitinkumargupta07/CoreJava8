package com.paniclater.initializing;

//here's the order of execution and why you can't pass an instance variable of either parent or child into the superconstructor
//First, all the static variables are initialized and assigned values, 
//so the first thing that happens it that s goes on the stack and a String object is created and assigned to the static reference s
//Next we hit go. new Go() is an implied reference of Go class, so at this time the static initialization blocks run.
//The first static initialization block concatenates s with "sb ". 
//Since strings are immutable the old string "-" is abandoned in the string pool and a new string object is created and referenced by s - "-sb"
//The next static block runs in order, declaring string reference variable s5 and assigning it to a newly created String object "s5"
//Next we are out of the implied reference and static blocks have run, so we are in honest to goodness instantiation.
//The first thing that happens is that we hit the reference to super(). This occurs before instance init blocks!
//Because no instance init blocks have run, at this point anything besides a String literal or the string object referenced by the static var s will lead to a compiler error!
//The important thing to remember is that instance init blocks run after the call to super.
//If the only superclass is object it seems like the instance blocks run first, but they really don't, we call objects super() which doesn't seem to do anything
//and then run the instance init blocks.


class Game {
	static String s = "-";
	String s2 = "s2";
	Game(String arg) { 
		s += arg; 
	}
}

public class Go extends Game {
	String s3 = "s3";
	static { s += "sb "; }
	static { String s5 = "s5"; }
	{String s4 = "s4";}
	{ s += "i "; }
	Go() { 
		//all of these constructors that are commented out do not compile because the variables that they refer to are not available
		//at the time the super constructor is called.
		//super(s2);
		//super(s3); 
		//super(s4);
		//super(s5);
		//String s6 = "s6";
		//super(s6);
		super("");
	}
	
	
	public static void main(String[] args) {
		new Go();
		System.out.println(s);
	}
	
	
}