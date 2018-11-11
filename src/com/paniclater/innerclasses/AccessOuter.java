package com.paniclater.innerclasses;

public class AccessOuter {
	void go() { System.out.println("AccessOuter Go"); }
	public static void main(String[] args) {
		AccessOuter o = new AccessOuter();
		AccessOuter.AccessInner i = o.new AccessInner();
		o.go(); //just as you would expect
		i.go();	//also not surprising
	}
	class AccessInner {
		void go() { 
			//in order to access a member (method or variable, etc) of an outer class
			//you use the syntax [ClassName].this.[member]
			AccessOuter.this.go();
			System.out.println("AccessInner Go"); 
		}		
	}
}