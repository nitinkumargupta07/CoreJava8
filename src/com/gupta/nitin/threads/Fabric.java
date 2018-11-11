package com.gupta.nitin.threads;

public class Fabric extends Thread {
	public static void main(String[] args) {
		Thread t = new Thread(new Fabric());
		Thread t2 = new Thread(new Fabric());
		t.start();
		t2.start();
	}

	//will not compile if it is static void run() {
	public void run() {
		for(int i = 0; i < 2; i ++)
			System.out.print(Thread.currentThread().getName() + " ");
	}

}