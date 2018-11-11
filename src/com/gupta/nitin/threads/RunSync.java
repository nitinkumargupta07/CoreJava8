package com.gupta.nitin.threads;

public class RunSync {
	public static void main(String[] args) {
		//create an instance of a class that implements runnable
		Runner runner = new Runner();
		//create a couple threads and pass them the runner instance so they will execute its public void run() method when start is called
		Thread t1 = new Thread(runner);
		Thread t2 = new Thread(runner);
		//make the threads go!
		t1.start();
		t2.start();
	}
	
}

class Runner implements Runnable {
	public static int sleepCount = 0;
	public void run() {
		//call two methods, one synchronized, one not 3 times each
		//both methods make the current thread go to sleep
		for(int i = 0; i < 4; i++) {
			//since goSleep() is not synchronized, each thread can access it whenever it wants.
			//this means the threads do their sleeping together(probably...)
			goSleep();
			//since goSafeSleep() is synchronized once a thread gets a lock on the Runner class 
			//no other method can enter its synchronized methods
			//this means that each thread trying to access the method has to sleep on its own (how lonely....)
			goSafeSleep();
		}
	}
	void goSleep() {
		try {
			//remember sleep must be wrapped in try catch!
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
		System.out.println("Go Sleep + Thread.currentThread.getId()");
		sleepCount += 1;
			
	}
	synchronized void goSafeSleep() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
		System.out.println("Go Safe Sleep + Thread.currentThread.getId()");
		sleepCount += 1;
	}
}