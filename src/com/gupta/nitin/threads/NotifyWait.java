package com.gupta.nitin.threads;


public class NotifyWait {
	public static void main(String[] args) {
		Sally sally = new Sally();
		Thread t1 = new Thread(sally);
		Thread t2 = new Thread(sally);
		Thread t3 = new Thread(sally);
		Thread t4 = new Thread(sally);
		t1.start(); t2.start(); t3.start(); t4.start();
	}
}
class Sally implements Runnable {
	public void run() {
		Bob bob = new Bob();
		bob.go();
		bob.notify();
	}
}
class Bob {
	synchronized void go() {
		for(int i = 0; i < 10; i++) {
		try {
			Thread.currentThread().sleep(1000);
			this.wait();
		} catch (InterruptedException IE) {
			System.out.println(IE);
		}
		System.out.println("Go " + Thread.currentThread().getId());
		}
	}
}