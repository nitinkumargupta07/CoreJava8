package com.paniclater.exceptional;

import java.io.*;
//The goal was to write code that could keep running after exceptions had been thrown and caught by taking advantage of a multithread environment
public class MultiThreadException {
	public static void main(String[] args) {
		System.out.println("Starting");
		Fast fast = new Fast();
		System.out.println("Have runnable");
		Thread t1 = new Thread(fast);
		Thread t2 = new Thread(fast);
		Thread t3 = new Thread(fast);	
		t1.start(); t2.start(); t3.start();
		System.out.println("After thread");
		
	}	
}

class Fast implements Runnable {
	public void run() {
		try {
			System.out.println("In try");
			for(int x = 0; x < 10; x++) {
				for(int y = 0; y < 100; y++) {
					System.out.println(Thread.currentThread().getName() + " " + x + " " + y);				
				}
				System.out.println("In loop");
				System.out.println(Thread.currentThread().getId());
				throw new IOException();
				////System.out.println("After exception thrown");
			}
		} catch(IOException ioe) {
			System.out.println("In catch");
			System.out.println(ioe);
		}
	
	}
}