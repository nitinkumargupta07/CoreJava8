package com.gupta.nitin.collections;
import java.util.*;

class Dog { 
	int size; 
	Dog(int s) { size = s; }
	public int getSize() {
		return size;
	}
}
class DogComp implements Comparator<Dog> {
	public int compare(Dog a, Dog b) {
		return ((Integer)a.getSize()).compareTo(b.getSize());
	}
}
public class FirstGrade {
	public static void main(String[] args) {
		TreeSet<Integer> i = new TreeSet<Integer>();
		DogComp dogComp = new DogComp();
		TreeSet<Dog> d = new TreeSet<Dog>(dogComp);
		d.add(new Dog(1)); d.add(new Dog(2)); d.add(new Dog(1));
		i.add(1); i.add(2); i.add(1);
		System.out.println(d.size() + " " + i.size());
	}
}