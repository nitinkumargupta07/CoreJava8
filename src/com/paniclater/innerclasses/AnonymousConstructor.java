package com.paniclater.innerclasses;

public class AnonymousConstructor {
	public static void main(String[] args) {
		//I'm not sure how to explicitly call one of the arg super constructors
		MyBob my = new MyBob() { };	

	}
}

class MyBob extends Thread {
	MyBob() {
		System.out.println("No arg constructor");
	}
	MyBob(String a) {
		System.out.println("Arg constructor");
	}
	MyBob(String a, String b) {
		System.out.println("2 arg constructor");
	}
	public void run() {
		System.out.println("Outer");
	}
}