package com.gupta.nitin.constructors;

public class Constructor extends SuperConstructor {
	public static void main(String[] args) {
		new Constructor();
		new SuperSuperConstructor(8);	
		new SuperSuperConstructor(6) {
			
		};		
	}
}

class SuperConstructor extends SuperSuperConstructor {
	SuperConstructor() {
		//this class must call super and pass in an int -- otherwise 
		//when the superconstructor runs there will be an argument 
		//miss match error at compile time
		super(8);
	}	
}

class SuperSuperConstructor {
	//If you only declare one constructor and it takes an argument
	//the compiler WILL NOT create a default no-arg constructor for you
	//this means that in every class that extends this one
	//you must override the default constructor and make a call to super with
	//the requisite type and number of arguments supplied
	//otherwise you get a compiler error!
	SuperSuperConstructor(int height) {
		this(height, height);
	}
	SuperSuperConstructor(int height1, int height2) { }
}

