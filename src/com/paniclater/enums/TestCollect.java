package com.paniclater.enums;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

public class TestCollect {

	enum Children {
		Zero, Michelle, Lisa, Sarina, Brenda;
	}

	public static void main(String[] argv) {
		Set<String> set = new TreeSet<String>();
		set.add(Children.Zero.toString());
		set.add(Children.Michelle.toString());
		set.add(Children.Lisa.toString());
		set.add(Children.Sarina.toString());
		set.add(Children.Brenda.toString());

		for (String i : set)
			System.out.println("" + i);
		System.out.println("***************************888");
		Set<Children> set2 = new TreeSet<Children>();
		set2.add(Children.Michelle);
		set2.add(Children.Lisa);
		set2.add(Children.Sarina);
		set2.add(Children.Brenda);
		set2.add(Children.Zero);
		for (Children i : set2)
			System.out.println(i.name());
		
		BigDecimal d=new BigDecimal(123421342.573475);
		System.out.println(d.toString());
		System.out.println(d.toPlainString());
		System.out.println(d);
		System.out.println(d.toEngineeringString());
	}
}