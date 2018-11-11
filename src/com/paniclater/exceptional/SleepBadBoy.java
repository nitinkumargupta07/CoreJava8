package com.paniclater.exceptional;

public class SleepBadBoy {
	//Java says that exceptions must be either handled or declared.
	//declareSleep "declares" the exception, so it bubbles up to main, where the call must be wrapped in a try catch.
	//handle wraps the call to sleep in a try catch which takes care of it
	//if you put "throws InterruptedException in main you wouldn't have to include a try catch anywhere,
	// but if an InterruptedException did occur you would be in trouble.
	public static void main(String[] args) {
		SleepBadBoy sbb = new SleepBadBoy();
		try {
			sbb.declareSleep();
		} catch (InterruptedException ie) {
			System.out.println("Caught InterruptedException in main");
		}
		sbb.handleSleep();	
	}
	void declareSleep() throws InterruptedException {
		Thread t = new Thread();
		t.start();
		t.sleep(1000);
	}
	void handleSleep() {
		Thread t = new Thread();
		t.start();
		try {
			t.sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println("I'm interrupted! " + ie);
		}
	}
}
