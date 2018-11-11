package com.gupta.nitin.declaring;

//I got tripped up by a question that checked for creating multiple vars and assigning values on the same line. 
//Never again!
public class TestDeclare {
	//declare multiple primitives on one line
	int x, y, z;
	//declare multiple objects on one line
	Object a, b, c;
	//declare and assign values to multiple primitives on one line
	boolean d = true, e = false, f = true;
	//declare and instantiate multiple objects on one line
	Object g = new Object(), h = new Object(), i = new Object();
	//declare an object with parent type reference value and instantiate and assign to child type object!
	Object t = new Extended(), u = new Extended(), v = new Extended();
	public static void main(String[] args) {
		//Do the same thing inside of a method body instead of inside class body
		int j, k, l;
		int m = 0, n = 1, o = 2;
		Object q = new Object(), r = new Object(), s = new Object();
	}
}

class Extended {

}