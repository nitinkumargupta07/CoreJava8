package com.paniclater.format;

public class WithVars {
	public static void main(String[] args) {
		long x = 123456789;
		short y = 22766; // maximum value of a short is 32767
		System.out.printf("%1$+10d %2$010d \n", x, java.lang.Short.MAX_VALUE - y);
		//the second argument is a little bit easier for me to understand than the first
		//here's a breakdown %2$010d
		//% is the sign that signals a format code is about to begin
		//2$ indicates that it refers to the second argument i.e. java.lang.Short.Max_VALUE - y
		//next come the indications of how to format
		//0 means pad the number with zeroes -- this will fail at runtime with a MissingFormatWidthException
		//Next 10 means the width of the number should be 10. 
		//here's a breakdown fo the second format code:
		//%1$+10d
		//This starts out similarly % signals the format code is about to start
		//1$ refers to the first argument -- ie. x, ie. 123456789
		//+ means add a + to the front of the formatted string
		//10 means the width should be 10 chars long

		System.out.printf("%1$d %2$d \n", x, java.lang.Short.MAX_VALUE - y);
		System.out.printf("%1$+d %2$d \n", x, java.lang.Short.MAX_VALUE - y);
		System.out.printf("%1$+1d %2$d \n", x, java.lang.Short.MAX_VALUE - y);
		System.out.printf("%1$+10d %2$d \n", x, java.lang.Short.MAX_VALUE - y);
		System.out.printf("%1$+20d %2$010d \n", x, java.lang.Short.MAX_VALUE - y);
	}
}
