package com.paniclater.downcast;

abstract class Polygon {
	private int numSides;

	// if the first concrete class does not override all abstract methods declared
	// in a parent abstract class their will be a compile error
	abstract void sayHello();
}

class Rectangle extends Polygon {
	private int numSides = 4;
	private int height;
	private int length;

	Rectangle(int height, int length) {
		this.height = height;
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public int getLength() {
		return length;
	}

	@Override
	void sayHello() {
		System.out.println("Rect");
	}
}

class Square extends Rectangle {
	Square(int height, int length) {
		super(height, length);
		if (height != length) {
			// IllegalArgumentException is an unchecked error --
			// because of this you do not need to follow the handle / declare rule.
			System.out.println("Squares must have equal length and height!");
			throw new IllegalArgumentException();
		}

	}

	void sayHello() {
		System.out.println("Square");
	}
}

public class TestPolygon {
	public static void main(String[] args) {
		Square s = new Square(4, 4);
		System.out.println(s.getLength() + "=" + s.getHeight());
		// Remember that the reference variable type must pass IsA --
		// Is a square a rectangle? no. If the instantiated object does not pass the
		// test there will be
		// an incompatible types error at COMPILE TIME
		// Square r = new Rectangle(4,4);
		s.sayHello();

		Rectangle r = new Rectangle(4, 2);
		System.out.println(r.getLength() + "!=" + r.getHeight());
		r.sayHello();
		// Reference type Rectangle is ok because object type Square IsA Rectangle.
		// At runtime the Square object still behaves like a square -- it runs the
		// Square version of sayHello() not the rect one.
		// Rectangle rs = new Square(4,4);
		// The Square constructor runs:
		// So you can't pull shenanigans like this:
		// The compiler will let you get away with it because the parameter type and
		// number match the constructor arguments
		// But at runtime the constructor will throw the argument. and fail.
		Rectangle rs = new Square(4, 2);

		System.out.println(rs.getLength() + "=" + rs.getHeight());
		rs.sayHello();
	}

}
