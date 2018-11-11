package com.paniclater.exceptional;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class ParseBadBoy {
	public static void main(String[] args) {
		Locale germany = new Locale("German", "Germany");
		NumberFormat nf = NumberFormat.getInstance(germany);
		String s = "123.98";
		try {
			System.out.println(nf.parse(s));
		} catch (ParseException pe) {
			System.out.println(pe);
		}finally {
			System.out.println("nitin ");
		}
		s = "goo";
		try { 
			System.out.println(nf.parse(s));
		} catch (ParseException pe) {
			System.out.println(pe);
			return ;
		}
		finally {
			System.out.println("nitin ");
		}
		s = "123.98goo";
		try { 
			System.out.println(nf.parse(s));
		} catch (ParseException pe) {
			System.out.println(pe);
		}
		
	}
}