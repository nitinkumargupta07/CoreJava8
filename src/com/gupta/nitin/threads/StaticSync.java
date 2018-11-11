package com.gupta.nitin.threads;

public class StaticSync {
	public static void main(String[] args) {
		//here all of the non-static gos run simultaneously, but the static synchronized ones have to wait
		//this is because even though both methods are synchronized there is only one class lock, but each instantiation has its own
		//object lock. This means that each object is created, tries to run the non-static method and sees that nothing else has its lock
		//and so it is a go.

		//remember that static and non-static synchronized methods get entirely different locks and therefor never compete for resources
		for(int i = 0; i < 10; i++) new MyThread().start();	
	}
}

class MyThread extends Thread {
	public void run() {
		TestStatic test = new TestStatic();
		test.go();
		test.staticGo();
	}
}

class TestStatic {
	//there should be 2 locks involved here. 
	//The static method worries about the class lock
	//the non-static method worries about instance locks.
	synchronized static void staticGo() {
		System.out.println("Static go");
		try {
		System.out.println(Thread.currentThread().getId());
		Thread.currentThread().sleep(1000);
		} catch (InterruptedException IE) {

		}
	}
	synchronized void go() {
		System.out.println("Go");
		try {
		System.out.println(Thread.currentThread().getId());
		Thread.currentThread().sleep(1000);
		} catch (InterruptedException IE) {
		
		}
	}
}