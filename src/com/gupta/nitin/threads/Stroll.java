package com.gupta.nitin.threads;

public class Stroll {
	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new Mosey());

		//the question, is which fragments inserted will probably run most or all
		//of the main threads run() methods before running most of the t1 thread's run()?


		//option 1:
		
		// I think that the following gives t1 a low priority and starts main before starting t1, so it meets the requirements
		
		//give t1 a low priority
		//t1.setPriority(1);
		//start main's run
		//new Mosey().run();
		//start t1's run
		//t1.start();

		//option 2:
		
		//Even though t1 has a high priority I think main will finish all of it's run before t1 is started
		
		//give t1 a high priority
		//t1.setPriority(9);
		//start main's run
		//new Mosey().run();
		//start t1's run
		//t1.start();

		//option 3:
		
		//t1 is started first but it is given a low priority, so I think there is a good chance that main will finish first.

		//t1.setPriority(1);
		//t1.start();
		//new Mosey().run();

		//option 4:

		//I don't think this one qualifies -- it gives t1 a high priority and starts it first
		
		//give t1 a high priority
		//t1.setPriority(8);
		//start t1's run
		//t1.start();
		//start main's run
		//new Mosey().run();
	}
}

class Mosey implements Runnable {
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getId() + "-" + i + " ");
		}
	}
}