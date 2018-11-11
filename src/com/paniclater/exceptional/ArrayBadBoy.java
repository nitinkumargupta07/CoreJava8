package com.paniclater.exceptional;



public class ArrayBadBoy {
	public static void main(String[] args) {
		ArrayBadBoy abb = new ArrayBadBoy();
		abb.safe();
		//execution continues after safe, but stops at danger because no try / catch.
		abb.danger();	
	}
	void safe() {
		try {
			String[] sartre = {};
			String s = sartre[5];	
		} catch (ArrayIndexOutOfBoundsException oob) {
			System.out.println(oob + " can't do that.");
		}
	}
	void danger() {
		String[] sartre = {};
		String s = sartre[5];	
	}
}