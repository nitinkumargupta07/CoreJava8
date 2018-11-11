package com.gupta.nitin.threads;

public class GoSleep {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		t1.start();
		//sleep must be wrapped in a try catch block capable of handling an InterruptedException
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException IE) {
			System.out.println(IE);
		}
		
	}

}