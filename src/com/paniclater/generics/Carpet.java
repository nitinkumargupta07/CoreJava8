package com.paniclater.generics;

class A {}
class B extends A { }
class C extends B { }
public class Carpet<V extends B> {
	//The return type is Carpet<? extends V>
	//not sure what the <X extends V> before the return type is
	//it needs a parameter that matches the argument Carpet<? super X> type
	public static void main(String[] args) {
		//make a new Carpet object. It can be of generic type anything that extends B
		//Carpet<B> carpet = new Carpet<B>();
		//Carpet<C> carpet = new Carpet<C>();
		//I thought it would be possible to reference the type variable declared in the class, but when you run the program 
		//you get a compiler error: non-static type variable V cannot be referenced from a static context
		//Carpet<V> carpet = new Carpect<V>();
		//so I tried to make a method that will return type V
		Carpet<B> carpet = new Carpet<B>();
		//now I'm extra weirded out because I thought that polymorphism doesn't apply to generic types -- but 
		Carpet<B> carpetBV = carpet.makeVee();
	}
	public Carpet<V> makeVee() {
		return new Carpet<V>();
	}
	public <X extends V> Carpet<? extends V> method(Carpet<? super X> e) {
		//the next line works but throws a compiler WARNING (still compiles and executes),
		//this is to make generics safe for old java code
		//however, since new Carpet() isn't guaranteed to be of generic type<? extends V> (any class or subclass of V)
		//it might break at runtime! 
		//return new Carpet();	
		
		//the only acceptable options from the choices are the following two lines
		//the next one works because the method tells us that X extends V

		//return new Carpet<X>();
		return new Carpet<V>();		
			
		//the next three lines doesn't work it needs something of type variable where V extends B
		//one would think that type V would match B or C but the problem is the book says 
		//you cannot use concrete classes in the generic type in this situation because the 
		//exact scope of V is unknown.

		//return new Carpet<A>();
		//return new Carpet<B>();
		//return new Carpet<C>();
	} 
}