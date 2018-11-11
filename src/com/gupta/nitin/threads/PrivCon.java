package com.gupta.nitin.threads;

class SafeDeposit {
	private static SafeDeposit sd;
	public static SafeDeposit getInstance() {
		if(sd == null) sd = new SafeDeposit();
		return sd;
	}
	private SafeDeposit() { }
}

public class PrivCon {
	public static void main(String[] args) {
		String checker;
		SafeThief wizard = new SafeThief();
		SafeThief wizard2 = new SafeThief();
		for(int i = 0; i < 10; i ++) {
			new Thread(wizard).start();
			new Thread(wizard2).start();
		}

	}
}

class SafeThief implements Runnable {
	public void run() {
		System.out.println(SafeDeposit.getInstance().toString());
			
	}
}