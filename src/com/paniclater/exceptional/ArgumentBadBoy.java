package com.paniclater.exceptional;

import java.io.IOException;

class Test {
	public static void main(String[] args) {
		Test t = new Test();
		int i = t.check();
		System.out.println(i);
	}

	int check() {
		try {
			throw new IOException();
			//// return 1;// line 13
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally returning");
		}
		return 0;
	}
}

class Test1 {
	public static void main(String[] args) {
		Test1 t = new Test1();
		int i = t.check();
		System.out.println(i);
	}

	int check() {
		try {
			System.out.println("try block");
			throw new Exception();
			/// return 1;
		} catch (Exception e) {
			System.out.println("catch block");
			return 2;
		} finally {
			System.exit(0);
			System.out.println("finally returning");
			return 3;
		}
	}
}

class Test2 {
	public static void main(String[] args) {
		Test2 t = new Test2();
		int i = t.check();
		System.out.println(i);
	}

	int check() {
		try {
			System.out.println("try block");
			return 1;
		} catch (Exception e) {
			System.out.println("catch block");
			return 2;
		} finally {
			System.out.println("finally returning");
			return 3;
		}
	}
}

class Test3 {
	public static void main(String[] args) {
		Test3 t = new Test3();
		int i = t.check();
		System.out.println(i);
	}

	int check() {
		try {
			System.out.println("try block");
			System.exit(0);
			return 1;
		} catch (Exception e) {
			System.out.println("catch block");
			return 2;
		} finally {
			System.out.println("finally returning");
			return 3;
		}
	}
}

public class ArgumentBadBoy {
	public static void main(String[] args) {
		ArgumentBadBoy abb = new ArgumentBadBoy();
		int i = -1;
		try {
			abb.fail(i);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae);
		}
	}

	void fail(int i) {
		if (i < 0)
			throw new IllegalArgumentException("i must be greater than 0!");
	}
}
