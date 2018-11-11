package com.paniclater.imports.packageb;
import com.paniclater.imports.packagea.A;

public class B {
	A a;
	public B() {
		a = new A();
		a.greet();
	}
	public void greet() {
		System.out.println("Hello, I'm B");
	}
}