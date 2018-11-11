package com.paniclater.exceptional;

public class AssertionBadBoy {
	int x = 0;
	//never catch errors.
	void checkX() {
		assert x == 1;
	}
	public static void main(String[] args) {
		AssertionBadBoy abb = new AssertionBadBoy();
		abb.checkX();	
	}	
}