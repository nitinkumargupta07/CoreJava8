package com.paniclater.flow;

public class Modulos {
	public static void main(String[] args) {
		int x = 3;
		for(int i = 0; i < 3; i++) {
			System.out.println("Iteration " + i);
			System.out.println("i == 1 " + (i == 1));
			System.out.println("x = " + x);
			if(i == 1) {
				//System.out.println("assigning x++ to x");
				x = ++x;
			}
			//System.out.println("x = " + x);
			if(i % 2 == 0 && x % 2 == 0) System.out.print(".");
			if(i % 2 == 0 && x % 2 == 1) System.out.print("-");
			if(i == 2 ^ x == 4) System.out.print(",");
		}
		//System.out.println(x);
		System.out.println("<");
	}
}