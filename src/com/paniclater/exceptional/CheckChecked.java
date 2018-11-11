package com.paniclater.exceptional;
public class CheckChecked {
	public static void main (String[] args) throws Exception {
		try {
			doStuff();
		} catch (Exception e) {
			System.out.println("e"+e);
		}	
	}
	static void doStuff() throws Exception {
		throw new Exception();
	}
}