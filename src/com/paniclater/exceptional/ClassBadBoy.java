package com.paniclater.exceptional;

public class ClassBadBoy {
	public static void main(String[] args) {
		ClassBadBoy cbb = new ClassBadBoy();
		cbb.safe();
		cbb.danger();
	}

	void safe() {
		try {
			// B IS-A A so you can have an A reference var refer to its subtype B
			A ab = new B();
			// C IS-A A so you can have an A reference var refer to its subtype C
			ab = new C();
			// Now that A type reverence var refers to a C object it is totally ok to cast
			// it as a C object.
			C cb = (C) ab;
			// Same error will be thrown if we try:
			// ab = (C) ab;
			// B IS-A A so our ref variable a can still be assigned to a new B();
			ab = new B();
			// Now we ask the JVM to cast our B object to a C type. The compiler lets this
			// go, because as we saw earlier,
			// it is totally possible for the A reference variable type to be pointing at a
			// C object. However, at runtime we encounter
			// a class cast exception because B does not pass IS-A muster for type C.
			ab = (C) ab;

		} catch (ClassCastException cce) {
			System.out.println(cce);
		}
	}

	void danger() {

	}
}

class A {
}

class B extends A {
}

class C extends A {
}