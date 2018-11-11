package com.gupta.nitin.threads;

public class DMV implements Runnable {
	public static void main(String[] args) {
		// create a new DMV, assign it to d
		DMV d = new DMV();
		//pass it as an argument to new Thread -- meaning that its run will be substituted for the default run in thread
		//start the thread 
		new Thread(d).start();
		//do the same as above, this time also assigning a ref variable to the new Thread object -- this won't have any effect since 
		//nothing tries to reference either object in the code by a reference variable
		Thread t1 = new Thread(d);
		t1.start();
		//basically at this point we have 3 threads running, main, the anonymous thread and t1. t1 and the anonymous thread will both be competing to complete d's run method
	}
	public void run() {
		//each thread will attempt to run do1 and do2 4 times
		for (int j = 0; j < 4; j++) { do1(); do2(); }
	}
	void do1() {
		//since do1 isn't synchronized both threads can access this method simultaneously
		//this means that they can sleep at the same time
		try { Thread.sleep(1000); }
		catch (Exception e) { System.out.println("e "); }
	}
	synchronized void do2() {
		//since do2 is synchronized this means that both threads cannot access the method at the same time
		//we can't guarantee which thread will enter first, but we can guarantee that whichever thread enters has to finish its sleep before the second thread can start
		try { Thread.sleep(1000); }
		catch (Exception e) { System.out.print("e "); }
	}
}

//this is how execution of this code looks --
//we create both threads and start them.

//The following happens 1x:
//Both threads will enter do1 at about the same time -- 1 second passes
//One thread will enter do2 -- 1 second passes
//Next thread will enter do2 -- 1 second passes
//the following happens 3x:
//from here on out 1 piece of code will be delayed one second, this means that they will alternate 
//Each thread will enter do1 followed by do2 without waiting -- 2 seconds


//The code finishes.
//this means that the code takes about 9 seconds to finish
//If do2 wasn't synchronized the following would happen 4x:

//Both threads enter do1 at about the same time -- 1 second passes
//Both threads enter do2 at about the same time -- 1 second passes

//this would mean it would only take about 8 seconds to complete.
