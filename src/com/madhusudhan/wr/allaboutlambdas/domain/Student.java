package com.madhusudhan.wr.allaboutlambdas.domain;

import java.util.HashSet;
import java.util.Set;

public class Student {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	private String name = null;
	private Teacher teacher = null;
	private Set<String> book;

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}

	public void addBook(String book1) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book1);
	}

	public boolean hasTeacher() {
		return teacher != null ? true : false;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", teacher=" + teacher + "]";
	}

}
