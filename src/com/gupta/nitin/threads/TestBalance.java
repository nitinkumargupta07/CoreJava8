package com.gupta.nitin.threads;

public class TestBalance {
	public static void main(String[] args) {
	
	}
}

class Balance {
	private int balance;
	//when a method is synchronized the thread gets a lock as soon as it enters the method
	public synchronized int getBalance() { return balance; }
	public void deduct(int amount) {
		//when a block is synchronized it must specify the lock it needs and then the lock is acquired as soon as the block is invoked
		synchronized(this) {
		if((getBalance() - amount) >= 0) {
			balance -= amount;
		} else {
			System.out.println("Don't go negative! You only have " + balance + " and you want to deduct " + amount);
		}
		}
	}
}