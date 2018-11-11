package com.paniclater.innerclasses;

public class SameName {
	
	public static void main(String[] args) {
		Box box = new Box();
		box.go(); //straightforward, produces "1" because it picks the go from the outer class ref var
		Box.InnerBox innerBox = box.new InnerBox();
		innerBox.go(); //also straightforward, produces "2" because it picks the go from the inner class ref var
	}
	
}

class Box {
	void go() { System.out.println("1"); }
	//can't have multiple classes with the same name in the same namespace
	class InnerBox {
		void go() { System.out.println("2"); }
	}
	Box() {
		System.out.println("Entering Constructor");
		//different scope, so it is ok
		new InnerBox().go(); 
		//a little bit more confusing, but the key to remember is that the method local innerbox hasn't been declared yet
		//because of that the output will be 2 from the the "regular" inner class above
		class InnerBox {
			void go() { System.out.println("3"); }
		}
		new InnerBox().go(); //this one prioritizes the method local inner class! The output will be 3!
		System.out.println("Exiting Constructor");
	}
}