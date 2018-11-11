package com.paniclater.format;
import java.text.*;
import java.util.*;
public class ParseAndFormat {
	public static void main(String[] args) {
		//get a locale - first argument is language, second country
		Locale l = new Locale("Portuguese", "Brazil");
		//get a NumberFormat -- available only through the getInstance, getCurrencyInstance etc methods. Pass the created locale to the 
		//get method, otherwise it will just use the default locale of the machine.
		NumberFormat nf = NumberFormat.getCurrencyInstance(l);
		//nf.format will take a number and turn it into a string
		String s = nf.format(35.77);
		System.out.println(s);
		Number n = 0;
		//nf.parse will return a Number object. In order to get a primitive use the xxxValue() method of the wrapper class.
		try {
			n = nf.parse(s);
		} catch (ParseException pe) {
			System.out.println(pe);
		}
		try {
			System.out.println(nf.format("String"));
		} catch (IllegalArgumentException iae) {
			System.out.println(iae);
		}
		Double d = n.doubleValue();
		System.out.println(d);
		NumberFormat regnf = NumberFormat.getInstance();
		System.out.println(regnf.format(3010101));
		try {
			System.out.println(regnf.parse("36.7sx"));
			System.out.println(regnf.parse("36.7xs66"));
			System.out.println(regnf.parse("xs36.7sx"));
		} catch (ParseException pe) {
			System.out.println(pe);
		}
	}
}