package com.paniclater.polymorphism;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.paniclater.polymorphism.subpackage.OverridePackageAnimal;

public class Animal {

	public Animal eat() {
		System.out.println("super class eat");
		return new Animal();
	}

	protected void sleep() {
		System.out.println("super class sleep");
	}

	// Rule #6: The overriding method must not throw new or broader checked
	// exceptions.
	public void drink() throws FileNotFoundException, NullPointerException {
		System.out.println("super class sleep");
	}

	public void drink1() throws FileNotFoundException {
		System.out.println("super class sleep");
	}

	public void drink2() throws FileNotFoundException {
		System.out.println("super class sleep");
	}

	public void drink3() throws IOException {
		System.out.println("super class sleep");
	}

	public void drink4() throws IOException {
		System.out.println("super class sleep");
	}

	static void sleep1() {
		// animal sleeping code...
	}

	protected void move() {
	}

	protected void move1() throws IOException {
	}
}

class Dog extends Animal {

	/*
	 * public Animal eat() { System.out.println("sub class eat"); return new
	 * Animal(); }
	 */
	// The overriding method must have same return type (or subtype).
	public Dog eat() {
		System.out.println("sub class eat");
		return new Dog();
	}
	// return type String is not compatible
	/*
	 * public String eat() { System.out.println("sub class eat"); return "Dog"; }
	 */

	// The access level cannot be more restrictive than the overridden method’s
	// access level. For example: if the super class method is declared public then
	// the overridding method in the sub class cannot be either private or
	// protected.
	/*
	 * void sleep() { System.out.println("super class sleep"); }
	 */

	protected void sleep() {
		System.out.println("super class sleep");
	}

	// Its perfect legal do not send any Exception
	public void drink() {
		System.out.println("super class sleep");
	}

	// Its perfect legal do not send any number of Runtime Exception
	public void drink1() throws NullPointerException {
		System.out.println("super class sleep");
	}

	// You can not throws Broader checked Exception.
	/*
	 * public void drink2() throws IOException {
	 * System.out.println("super class sleep"); }
	 */
	// You can send narrower exception in child class
	public void drink3() throws FileNotFoundException, RuntimeException {
		System.out.println("super class sleep");
	}

	public void drink4() throws NullPointerException, IOException {
		System.out.println("super class sleep");
	}

	// error: sleep() in Dog cannot override sleep() in Animal
	/*
	 * void sleep1() { // animal sleeping code... }
	 */
	// Rewritten static method is perfectly leagal
	static void sleep1() {
		// animal sleeping code...
	}

	// The following example shows an illegal overriding attempt because the
	// InterruptedException is a new and checked exception:
	/*
	 * protected void move() throws IOException, InterruptedException { // Dog
	 * moving code... }
	 */
	// The following example shows an illegal overriding attempt because the
	// InterruptedException is a new and checked exception:
	/*
	 * protected void move1() throws IOException ,InterruptedException { }
	 */
	//IllegalArgumentException is unchecked exception.
	protected void move1() throws IOException ,IllegalArgumentException { }
}

class UpperPackage extends OverridePackageAnimal {
	public void packageCheck() {
	}
}
