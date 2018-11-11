package com.paniclater.exceptional;

public class NumberFormatBadBoy {
	public static void main(String[] args) {
		String s = "5";
		Integer i = Integer.valueOf(s);
		try {
			s = "Five";
			i = Integer.valueOf(s);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe);
		}
	}		
}
