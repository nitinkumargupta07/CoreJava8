package com.gupta.nitin.collections;

import java.util.*;

class Box implements Comparable<Box> {
	private Integer size;

	Box() {
		size = (int) (Math.random() * 50);
	}

	Box(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		return size;
	}

	public int compareTo(Box a) {
		return size.compareTo(a.getSize());
	}

	public boolean equals(Object o) {
		if (o instanceof Box) {
			return size.equals(((Box) o).getSize());
		}
		return false;
	}

	// best practice to override hashCode() every time you override equals, the
	// following is a very, very bad implementation of hashCode()
	public int hashCode() {
		return size;
	}
}

class TestBoxQueue {
	Queue<Box> boxes;

	TestBoxQueue() {
		boxes = new PriorityQueue<Box>();
		for (int i = 0; i < 10; i++) {
			boxes.offer(new Box());
		}

		System.out.println(boxes.size());
		Integer mySize = boxes.peek().getSize();
		System.out.println(mySize);
		// the following will only work if you override public boolean equals(Object o)
		// in your custom case
		System.out.println(boxes.contains(new Box(mySize)));
		System.out.println(boxes.remove(new Box(mySize)));
		System.out.println(boxes.contains(new Box(mySize)));
	}
}

public class TestQueue {
	public static void main(String[] args) {
		 TestIntegerQueue tiq = new TestIntegerQueue();
		TestBoxQueue tbq = new TestBoxQueue();
	}
}

class TestIntegerQueue {
	Queue<Integer> intQueue;

	TestIntegerQueue() {
		intQueue = new PriorityQueue<Integer>();
		Integer i = new Integer(5);
		// Integer is one of the wrapper classes and all the wrapper classes implement
		// natural ordering
		// because of this Integer works with all sorted collections out of the box
		System.out.println(intQueue.add(i));
		System.out.println(intQueue.contains(i));
		System.out.println(intQueue.remove(i));
		// offer is the same as add except it isn't forced to throw an exception every
		// time it fails, it can
		// merely return false
		System.out.println(intQueue.offer(i));
		System.out.println(intQueue.contains(i));
		// peek reveals the first element in the queue (which will be the lowest integer
		// in this case, the only integer object)
		System.out.println(intQueue.peek());
		// poll reveals the first element in the queue and removes it.
		System.out.println(intQueue.poll());
		System.out.println(intQueue.contains(i));

		// create 3 integers and add them to the queue
		Integer a = new Integer(1);
		Integer b = new Integer(-8);
		Integer c = new Integer(500);

		intQueue.offer(a);
		intQueue.offer(b);
		intQueue.offer(c);

		// create 3 identical integers and add them to the queue
		Integer d = new Integer(1);
		Integer e = new Integer(-8);
		Integer f = new Integer(500);

		System.out.println(intQueue.size());

		// see if those are in the queue
		QueueUtil qu = new QueueUtil();
		// these return true because they are identical to the a, b, and c Integer
		// objects
		qu.readableContains(intQueue, d);
		qu.readableContains(intQueue, e);
		qu.readableContains(intQueue, f);

		intQueue.offer(d);
		intQueue.offer(e);
		intQueue.offer(f);

		System.out.println(intQueue.size());

		// remove them from the queue
		intQueue.remove(d);
		intQueue.remove(e);
		intQueue.remove(f);
		System.out.println(intQueue.size());
		Iterator it = intQueue.iterator();
		while (it.hasNext() == true)
			System.out.println(it.next());
		System.out.println("\n");
		System.out.println(intQueue.size());
		intQueue.offer(a);
		intQueue.offer(b);
		intQueue.offer(c);
		intQueue.offer(d);
		intQueue.offer(e);
		intQueue.offer(f);
		System.out.println("\n");
		System.out.println(intQueue.size());
		it = intQueue.iterator();
		System.out.println("\n");

		// remember that priority queue only guarantees sorted order when pulling stuff
		// out of the front or end of the queue,
		// it does not guarantee sorted iteration
		while (it.hasNext() == true)
			System.out.println(it.next());
	}
}

class QueueUtil {
	public <T> void readableContains(Queue<T> pq, T t) {
		System.out.println("Contains " + t.toString() + " ?" + " " + pq.contains(t));
	}
}