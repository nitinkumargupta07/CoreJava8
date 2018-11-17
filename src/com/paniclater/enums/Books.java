package com.paniclater.enums;

import com.sun.security.jgss.ExtendedGSSContext;

import sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection;

/// Enums can implement interfaces
interface Price {
	public double price();
}

abstract class BB {
}

// public enum Books extends BB{ ///Syntax error on token "extends", implements// expected

public enum Books implements Price {

	HARRY_POTTER(12.99) {
		@Override
		void display() {
			// TODO Auto-generated method stub

		}
	},
	THE_SOULFORGE(12.11) {
		@Override
		void display() {
			// TODO Auto-generated method stub

		}
	},
	GAME_OF_THRONES(10.00) {
		@Override
		void display() {
			// TODO Auto-generated method stub

		}
	},
	DRAGONLANCE(6.77) {
		@Override
		void display() {
			// TODO Auto-generated method stub

		}
	};

	private final double price;

	// Enums can not created by new keyword since their constructor is private. You
	// don’t need to declare its constuctor as private. Due to JLS
	/// If no access modifier is specified for the constructor of an enum type, the
	// constructor is private.
	/* public */ private Books(double price) {
		this.price = price;
	}

	abstract void display();

	@Override
	public double price() {
		return this.price;
	}
}
//The type Books cannot be the superclass of cc; a superclass must be a class
//class cc extends Books{}
////enum ccww extends Books{}

class TestDemo {

	public static void main(String[] args) {
		Books dragonlance = Books.DRAGONLANCE;
		// toString() method could be used to get their string representation.
		System.out.println(dragonlance.toString());

		// they can use '==' operator to check their equality
		if (dragonlance == Books.DRAGONLANCE) {
			System.out.println(true);
		}
	}

}