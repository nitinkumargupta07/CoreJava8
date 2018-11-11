package com.gupta.nitin.threads;

public class TestThreads {
	
	public static void main(String[] args) {
		TestRunnable myRunnable = new TestRunnable();
		Thread myThread = new Thread(myRunnable);
		Thread anotherThread = new Thread(myRunnable);
		ExtendsThread lastThread = new ExtendsThread();
		myThread.start();
		anotherThread.start();
		lastThread.start();
	}
}
class ExtendsThread extends Thread {
	String[] names = {"Bobby", "Andrea", "Dave", "Todd", "Kevin", "Ryan"};
	int nameIndex = 0;
	//remember the rules of overridding: 
	//argument list must match exactly
		// i.e. public void run(String s) is an overload not an override!
	//return type must be same or subtype
		// i.e. public String s run() is not an override!
	//access level can't be more restrictive
		// i.e. private void run() is not an override!
	//can only override if you inherit the method -- i.e. private methods cannot be overridden!
		// we can override public void run() because it is public -- we have access to it
	//overriding method cannot throw broader or new checked exceptions
		// i.e. public void run throws IOException would fail!
	//overriding methods CAN throw unchecked exceptions
		// i.e. that is why it is legal to throw StackOverflowError or ArrayIndexOutOfBoundsException
	public void run() throws ArrayIndexOutOfBoundsException {
		for (int i = 0; i < 100; i++) {
			//Threads have a name and an id. These members may be accessed through the getName() and getId() methods.
			System.out.println("Running " + i + " from extends: " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
			//You can also set the thread name
			nameIndex = (int)(Math.random() * names.length);
			Thread.currentThread().setName(names[nameIndex]);
			//sleep doesn't guarantee that threads will share resources, but it is the best way to try to get threads to share resources	
			//sleep takes an argument in millis, but it is important to remember that it doesn't guarantee the thread will wake up in that time
			//sleep only guarantees the current thread will sleep at LEAST that long
			//sleep is static -- even if it is invoked from an instance like anotherThread it will only affect the current running thread

			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			} 
		}
	}
}
class TestRunnable implements Runnable {

	// a class that implements a method from an interface must obey all of the rules for overriding plus
	// provide concrete implementation
		// i.e. you can't pass the buck and do public void run(); 
		// you have to implement: at least public void run() {}
	// declare NO checked exceptions on implementation methods other than those declared by any parent classes or interfaces
	// this is different from overridding! overridding allows broader checked, interfaces do not!
	// maintain signature and return type -- but don't worry about declaring the same exceptions.
	
	public void run() throws StackOverflowError {
		for(int i = 0; i < 100; i++) {

			System.out.println("Running " + i + " from implements: " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			} 
		}
	}
}