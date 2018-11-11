package com.gupta.nitin.threads;

public class TryJoin {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		t1.start();
		//join, sleep and wait can all be interrupted so they must be wrapped in try / catch blocks
		try {
			//the join method asks whatever thread is running to stop and wait for the thread the join method is called on to finish!
			t1.join();
			//it also takes an int milli of a sort of timeout clause -- i.e. wait for t1 to finish unless t1 takes x time, then go ahead.
			t1.join(500);
		} catch (InterruptedException ie) {

		}
	}
}