package com.paniclater.innerclasses;
public class RegularInner {
	//Regular Inner classes can have all four access levels and all 3 modifiers
	//They can be default, public, protected or private
	private int a = 0;
	class FirstInner {
		private int myA = 10;
		FirstInner() { a = 1; }
		public void setOuterVar() {
			a = 10;
		}
		public void setOuterVar(int a) {
			//in order to use this to reference the enclosing class you must use the Class --NOT INSTANCE-- name
			//plus dot syntax plus this. otherwise this refers to the inner class instance, not the outer class instance
			RegularInner.this.a = a + this.myA;

		}
	}
	public class SecondInner {
		SecondInner() { a = 2; }
	}
	protected class ThirdInner {
		ThirdInner() { a = 3; }
	}
	private class FourthInner {
		FourthInner() { a = 4; }
	}
	//you can have the abstract modifier for inner classes
	abstract class FifthInner {
		abstract void abstractMethod();
	}
	//you can extend other inner classes with other inner classes
	class SixthInner extends FifthInner {
		void abstractMethod() {}
	}
	public static void main(String[] args) {
		//Regular inner classes can be declared with a reference to the outer type followed by inner type via dot syntax
		//They can be assigned with a reference to an outer instance and new via dot notation followed by a space and the 
		//inner class constructer.
		//I named the outer class RegularInner, which is confusing, but it is because I wanted a separate file to test anonymous,
		//method local and argument inner classes
		RegularInner outer = new RegularInner();
		RegularInner.FirstInner first = outer.new FirstInner();
		RegularInner.SecondInner second = outer.new SecondInner();
		RegularInner.ThirdInner third = outer.new ThirdInner();
		RegularInner.FourthInner fourth = outer.new FourthInner();
		//This changes the value of outer because the inner class was instantiated through the outer instance of 
		//class RegularInner!
		first.setOuterVar();
		first.setOuterVar(20);



		//This works because we are inside Regular Inner, if we try this in a new class we are in trouble.
		System.out.println(outer.a);

		//!!!DOES NOT COMPILE!!!//

		//You cannot access members of outer class through inner members via dot syntax -- they are only members
		//of the outer class, not the inner
		// first.a = 1;
		// System.out.println(outer.a);

	}
}

class Outside {
	public static void main(String[] args) {
		RegularInner outer = new RegularInner();
		RegularInner.FirstInner first = outer.new FirstInner();
		RegularInner.SecondInner second = outer.new SecondInner();
		RegularInner.ThirdInner third = outer.new ThirdInner();
		
		//!!!DOES NOT COMPILE!!!//

		//Correct declaration and instantiation syntax but class Outside cannot see FourthInner because it has
		//private access. If we tried to instantiate first or third in a class in another package we would also through
		//a compiler error.
		//RegularInner.FourthInner fourth = outer.new FourthInner();
	}
}