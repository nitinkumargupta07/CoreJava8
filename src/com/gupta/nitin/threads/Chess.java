package com.gupta.nitin.threads;

public class Chess implements Runnable {
	public void run() {
		//Chess implements runnable, so this is what will happen when a Thread starts with 
		//a Chess object as an argument to the Thread constructor
		
		//move accepts the current Threads Id as an argument
		for(int i = 0; i < 100; i++)
		move(Thread.currentThread().getId());
	}
	//Insert code here
	synchronized void move(long id) {
	//void move(long id) {
		//move will simply print out the id that was passed to it 2x.
		System.out.print(id + " ");
		System.out.print(id + " ");
	}
	public static void main(String[] args) {
		//create a new chess object so it can be passed to a thread
		Chess ch = new Chess();
		//create a new thread, pass it the Chess object as an arg and start it -- this means that move will start.
		new Thread(ch).start();
		//create a new thread, pass it a new Chess object as an arg and start it -- this means that move will start.
		//I postulate that it doesn't matter that move is synchronized in this case as both Chess objects will have their own locks.
		//if new thread() was passed the same ch instance both times, then synchronization would come into play.
		new Thread(new Chess()).start();
		System.out.println("\n");
	}
}