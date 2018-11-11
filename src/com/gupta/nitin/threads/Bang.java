package com.gupta.nitin.threads;
/*package com.gupta.nitin.threads;

public class Bang extends Thread {
	Static Thread t1, t2, t3;
	public static void main(String[] args) throws Exception {
		//create 3 new Threads and have them execute Bang's run when they start
		t1 = new Thread(new Bang());
		t2 = new Thread(new Bang());
		t3 = new Thread(new Bang());
		//start each thread
		t1.start(); t2.start(); t3.start();
	}
	public void run() {
		//remember there is no guarantee which thread enters this code first
		//since the method isn't synchronized they can be in here simultaneously
		for(int i = 0; i < 500; i++) {
			//each thread will print out its id 250 times
			System.out.print(Thread.currentThread().getId() + " ");

			//one of them will get to i = 250 first -- we don't know which
			if(i == 250) {
				try { 
					//at that point t1's id will be printed 3x
					System.out.print("**" + t1.getId() + "**");
					whatever thread gets here first will be put to sleep -- this will happen three times, so each thread will eventually sleep for 1/2 second
					//total delay will be at least 1.5 seconds
					t1.sleep(600);
				} 
				catch (Exception e) { }
			}
}}}

//my verdict -- compilation succeeds, no exception is thrown
//It is difficult to predict which thread will finish first
//Bang will execute for a second or two.*/