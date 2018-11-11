package com.gupta.nitin.collections;
import java.util.*;

class Radio {
	String getFreq() { return "97"; }
	static String getF() { return "97"; }
}

public class Ham extends Radio {
	String getFreq() { return "50"; }
	static String getF() { return "50"; }
	public static void main(String[] args) {
		List<Radio> radios = new ArrayList<Radio>();
		//once the Collection has been created you are free to add any subclass of the parameter type.
		radios.add(new Radio());
		radios.add(new Ham());
		
		//however you cannot subclass the parameter type itself!
		//if you try you will get a compiler incompatible type error
		//List<Radio> hams = new ArrayList<Ham>();

		//polymorphism works for subclasses in collections
		//at compile time the compiler knows that radio objects have a getFreq() method
		//at runtime the actual object invokes the method, so the reference variable type is not relevant.
		for(Radio r : radios) System.out.println(r.getFreq());
		//polymorphism does not work for static methods! static methods can be redefined, but not overridden.
		//the reference var type determines the static method called.
		for(Radio r : radios) System.out.println(r.getF());


		//As you can see below, the reference variable determines which version of getF() will be called because getF() is static!
		Radio aRadio = new Ham();
		Ham aHam = new Ham();
		System.out.println(aRadio.getF());
		System.out.println(aHam.getF());

		
		
	}
}