package com.paniclater.generics;

import java.util.*;

public class RentalGeneric<T> {
	private List<T> rentalPool;
	private int maxNum;
	public RentalGeneric(int maxNumb, List<T> rentalPool) {
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}
	public T getRental() {
		return rentalPool.get(0);
	}
	public void returnRental(T returnedThing) {
		rentalPool.add(returnedThing);
	}
	public static void main(String[] args) {
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		List<Cat> cats = new ArrayList<Cat>();
		cats.add(c1);
		cats.add(c2);
		RentalGeneric<Cat> catRental = new RentalGeneric<Cat>(10, cats);
		Cat catToRent = catRental.getRental();
		catRental.returnRental(catToRent);
		//can't return a dog because Rental Generic is of generic type Cat!
		//catRental.returnRental(new Dog());
		//can't add ArrayList<Cat> to RentalGeneric<Dog> because parameter T in the constructor ensures the list that 
		//is passed to the constructor matches the type declared by the class!
		//RentalGeneric<Dog> dogRental = new RentalGeneric<Dog>(10, cats);
	}
}

class Cat { }
class Dog { }
class Book { }