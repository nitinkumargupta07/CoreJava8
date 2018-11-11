package com.paniclater.enums;

import com.sun.security.jgss.ExtendedGSSContext;

/// Enums can implement interfaces
interface Price {
	public double price();
}

class BB {
}

// public enum Books extends BB{ ///Syntax error on token "extends", implements
// expected
public enum Books implements Price {

	HARRY_POTTER(12.99), THE_SOULFORGE(12.11), GAME_OF_THRONES(10.00), DRAGONLANCE(6.77);

	private final double price;

	Books(double price) {
		this.price = price;
	}

	@Override
	public double price() {
		return this.price;
	}
}

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