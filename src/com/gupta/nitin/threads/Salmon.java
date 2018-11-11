package com.gupta.nitin.threads;

public class Salmon extends Thread {
	public static long id;
	public void run() {
		for(int i = 0; i < 4; i++) {
			//the first 2 invocations don't meet either code's requirements so i will be print out either way for 0 and 1
						
			//then pretty much either way the condition will get met. The only way we are in this block initially is if t1 ran start
			//so the id will match the first time through
			
			//the thread that started will not have the same id as t1, so it will not meet option 1's criteria
			//it would meet option 2's criteria it is unlikely that it will make it very far in the loop before the error is thrown though.

			//insert code here
			//option 1:
			if(i == 2 && id == Thread.currentThread().getId()) {
			//option 2
			//if(i == 2) {	
				System.out.println("made it");
				//we start a new thread and pass it a salmon object, this means when it starts it will use the 
				//Salmon's run method. keep in mind the original thread t1 keeps going.

				new Thread(new Salmon()).start();
				//output CANNOT continue after the unhandled error! As soon as the code hits here the program will halt
				throw new Error();
			}
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		//create a new Thread (Salmon) object
		Thread t1 = new Salmon();
		//assign the id of t1 to the static "id" long variable of Salmon class
		id = t1.getId();
		//start the thread (go to the code in the run method)
		t1.start();
		System.out.println(t1.getId());
	}
}

//my thoughts -- both fragments will not produce the same output EVERY time, although sometimes the error might get thrown before the new thread enters the conditional block
//both fragments will basically complete in the same time -- the error will cause the program to halt.
//compilation should be fine
//output MUST end when the error is thrown 
//output CANNOT continue after the error is thrown.

//this turned out to be completely wrong -- remember that unhandled exceptions and errors only cause the current thread to crash!
//in the event that a new thread is created BEFORE the error is thrown, the current thread dies but the new thread continues!