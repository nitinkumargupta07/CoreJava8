package com.paniclater.innerclasses;

//ok this is a leeeeetle bit screwy, but all the inner classes are here ( I think );
public class AllInner {
	private int privateVar = 5;
	private static int staticVar = 5;
	private final int finalVar = 5;
	
	//first up, your regular vanilla inner class, nothing much to see here, move along, move along
	class regular {
		//method inside of regular inner class
		void sayHello() {
			//regular inner class has special relationship with enclosing class, can access private members.
			System.out.println(privateVar);
		}
		
	}
	void sayHello() {
		//now we have a method-local inner class.
		class methodLocal {
			void sayHello() {
				//method-inner classes can still access private members of enclosing class!
				System.out.println(privateVar);
			}
			//and inside our method-local class we have an anonymous inner class! 
			//Watch out for curly-braces after instantiation parentheses!
			ParentOfAnon parent = new ParentOfAnon() {
				void sayHello() {
					System.out.println(privateVar);
				}
				
			};
			//they can even be trcky and be on the same line!
			//also remember to spot semicolons after curly braces for anonymous inner
			//it is one of the only times you need a semicolon after a curly every time.
			ParentOfAnon secondParent = new ParentOfAnon() {};
		}
		
	}
	// just a good ole method that takes an interface (obviously you can't instantiate an interface)
	// so what it actually takes is any class that implements the interface.
	void argAnon(ProudParent parent) {
		

	}
	public static void main(String[] arg) {
		//new instance of our class
		AllInner heyo = new AllInner();
		//ACK! we need to take an object that implements ProudParent, but we don't have one!
		//It kind of looks like an interface is being instantiated
		//But it is really an anonymous argument defined inner class -- the curly braces indicate
		//an anonymous class that is a child (i.e. implementer) of ProudParent! 
		//Anonymous instantiation of children elements on the fly ftw!
		heyo.argAnon(new ProudParent() {
			void sayHello() {
				//Can't access non-static vars from a static context!
				//System.out.println(privateVar);
				//Can only access static vars from here! (without an object instantiation of course!
				System.out.println(staticVar);
				System.out.println(var);
				
			}	
		});
	}
		
}

interface ProudParent {
	//interfaces can't have private variables
	//private int privateVar = 5;
	//this following variable is actually static and final by default!
	int var = 5;
}
class ParentOfAnon{}