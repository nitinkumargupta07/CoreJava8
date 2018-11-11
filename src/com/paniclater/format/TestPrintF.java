package com.paniclater.format;

public class TestPrintF {
	public static void main(String[] args) {
		System.out.printf("Hello\n");
		//%d is for decimal integers
		//%f is for floats and doubles (think decimals for f, integers for d)
		//%c is for character
		//%s is for string
		//%b is for boolean
		//order goes %[flags][width][.precision]conversion char
		//i.e.       % +0     10                d
		//becomes    %+010d
		System.out.printf("a boolean %b\n", true);
		byte b = 5;
		short s = 6;
		int i = 7;
		long l = 8;
		boolean t = true;
		String str = "A String";
		float f = 40.8f;
		double db = 590.2d;
		char c = 'c';
		System.out.printf("will multiple work? %0+4d %+010d %d %d %b %s %c %.2f %.2f\n", b, s, i, l, t, str, c, db, f);

	}
}