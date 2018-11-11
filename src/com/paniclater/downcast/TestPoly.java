package com.paniclater.downcast;

class A {
	private String name = "A";
	
	A() { System.out.print(name); }
	public void sayName() { System.out.println(name); }
}

class B extends A {
	private String name = "B";
	public void sayName() { System.out.println(name); }
	B() { System.out.print(name); }
}

class C extends B {
	private String name = "C";
	public void sayName() { System.out.println(name); }
	C() { System.out.print(name); }
}

class D extends B {
	private String name = "D";
	public void sayName() { System.out.println(name); }
	D() { System.out.print(name); }
}

class E extends C {
	private String name = "E";
	public void sayName() { System.out.println(name); }
	E() { System.out.print(name); }
}

public class TestPoly {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("\n");
		B b = new B();
		System.out.println("\n");
		C c = new C();
		System.out.println("\n");
		D d = new D();
		System.out.println("\n");
		E e = new E();
		System.out.println("\n");
		a.sayName(); b.sayName(); c.sayName();
		d.sayName(); e.sayName();		
		A aa = new A();
		System.out.println("\n");
		A ab = new B();
		System.out.println("\n");
		A ac = new C();
		System.out.println("\n");
		A ad = new D();
		System.out.println("\n");
		A ae = new E();
		System.out.println("\n");
		ab.sayName();
		((B) ab).sayName();
	}
		
	
}


