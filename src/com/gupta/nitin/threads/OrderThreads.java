package com.gupta.nitin.threads;

public class OrderThreads {
	//I'm going to attempt to combine an anonymous inner class with threading.
	public static void main(String[] args) {
		//this starts out business as usual but soon gets weird. The Thread constructor needs to take a class that 
		//implements runnable or extends the thread class.
		//So I create a new thread object and immediately start an anonymous inner argument class
		// -- this is an implied extender of the object it follows --
		//i.e. new Thread() {whatever happens in here is an anonymous class that extends thread}
		//inside my anonymous class I override public void run() -- this is the method that 
		//is called when t1.start() runs
		Thread t1 = new Thread(new Thread() {
			public void run() {
				for(int i = 1; i <= 100; i++) { System.out.println("Made it inside!"); }
			}
		});
		OrderThreads order = new OrderThreads();
		// order.countUp();
		t1.start();

		//t1.start();
		order.countUp();
	}
	void countUp() {
		for(int i = 1; i <= 100; i++) { System.out.println(i); }
	}
}