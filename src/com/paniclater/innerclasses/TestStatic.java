/*package com.paniclater.innerclasses;


public class TestStatic {
	
	public static void main(String[] args) {
		Box b = new Box();
		//static inner class instantiation is very different from non-static
		//Box.StaticBox sb = new Box.StaticBox();
		Box.InnerBox ib = new Box().new InnerBox();
		ib = b.new InnerBox();
	}
}
class Box {
	private String name = "Bob";
	static String type = "Box";
	static class StaticBox {
		StaticBox() {
			//Static inner classes cannot access non-static members of enclosing class
			//System.out.println(name);
			System.out.println(type);
		}
	}
	class InnerBox {
		//innerbox has no issues accessing private vars of enclosing class
		InnerBox() { 
			System.out.println(name);
			System.out.println(type); 
		}
	}
}*/