package com.paniclater.polymorphism;

import java.io.FileNotFoundException;

class Override {
	int add(int a , int b) throws IllegalArgumentException {
		return a + b;
	}
	
	int add12(int a , int b) throws FileNotFoundException ,NullPointerException {
		return a + b;
	}
}
public class LegalOverride extends Override {
	
	int add12(int a ,int b)  {long c=30; return  (int) c;}// add cost to int
	//the rules for an override must be followed for a program to compile unless the parameter types / numbers change, in which case it is a legal overload not override
	
	//cannot have more restrictive access
	//private int add(int a, int b) { return a + b; } WILL NOT COMPILE
	
	//can have less restrictive access
	///public int add(int a, int b) { return a + b; } 
	//must maintain return type
	///double add(int a, int b) { Double d = 10.0; return d; }// WILL NOT COMPILE
	//long add(int a ,int b) {long c=30; return c;}
	///short add(int a ,int b) {short c=30; return c;}
	///- The return type is incompatible with  Override.add(int, int)
	//cannot throw broader checked exceptions	
	//int add(int a, int b) throws Exception { return a + b; } WILL NOT COMPILE

	//cannot throw new checked exceptions
	////int add(int a, int b) throws IllegalArgumentException ,NullPointerException,ArrayIndexOutOfBoundsException { return a + b; }/// WILL NOT COMPILE

	//can throw narrower checked exceptions 
	int add(int a, int b) throws NumberFormatException {
		return a + b;
	}
	//if you change the parameter types then it is an overload not an override
	int add(String s) { return 5; }
	//if you change the paremeter numbers then it is an overload not an override
	int add(int a, int b, int c) { return a + b + c;  }
}