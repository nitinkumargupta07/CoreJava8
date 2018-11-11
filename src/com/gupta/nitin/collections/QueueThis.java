package com.gupta.nitin.collections;

import java.util.*;

public class QueueThis {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		//add 2 strings to pq
		System.out.print(pq.peek() + " ");
		System.out.print(pq.poll() + " ");
		pq.add("2");
		pq.add("4");
		//this will return 2 because Strings are comparable
		//peek returns an element but does not remove it from the queue
		System.out.print(pq.peek() + " ");
		//for the purpose of the exam offer == add
		pq.offer("1");
		pq.add("3");
		//remove 1, so now pq's contents will be 2,3,4
		pq.remove("1");
		//remove the first element of the queue -- so now the contents wil be 3,4
		System.out.print(pq.poll() + " ");
		//pq.remove("2") will return false, so !pq.remove("2") will return true
		//the poll statement will then remove the 3 from the collection
		if(!pq.remove("2")) System.out.print(pq.poll() + " ");
		//the pq.poll will remove the last element of the queue, so pq.peek() returns null
		System.out.println(pq.poll() + " " + pq.peek() + " " + pq.poll());

	}

}