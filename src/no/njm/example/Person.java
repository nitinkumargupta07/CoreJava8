package no.njm.example;

final class Person {

	String firstName;
	String lastName;
	String name;
	int age;

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
