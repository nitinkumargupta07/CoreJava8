package com.gupta.nitin.collections;
import java.util.*;

class Dog121 implements Comparable{ 
	int size; 
	Dog121(int s) { size = s; }
	public int getSize() {
		return size;
	}
	public int compareTo(Object o) {
		return ((Integer)size).compareTo(((Dog121) o).getSize());
	}
}

public class FirstGrade2 {
	public static void main(String[] args) {
		TreeSet<Integer> i = new TreeSet<Integer>();
		TreeSet<Dog121> d = new TreeSet<Dog121>();
		d.add(new Dog121(1)); d.add(new Dog121(2)); d.add(new Dog121(1));
		i.add(1); i.add(2); i.add(1);
		System.out.println(d.size() + " " + i.size());
	}
}