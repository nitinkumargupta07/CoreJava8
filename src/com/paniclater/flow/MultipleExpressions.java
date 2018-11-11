package com.paniclater.flow;

public class MultipleExpressions {
	public static void main(String[] args) {
		//you must have 2 semicolon, you can leave the sections empty, if you leave all sections empty this will result in an endless loop
		for ( ; ; ) {
			break;
		}
		//you can declare and instantiate multiple vars in the first part but they must be the same type
		for(int i = 0, j = 1; ; ) {
			break;
		}
		//you can only have one boolean expression, but you can make it super complicated (consisting of multiple nested booleans)
		for( ; ((true || ((false == false) ^ (true != false))));  ) { 
			break;
		}
		//you can declare multiple statements in the last "iterator" part, they must be separated with a comma, they don't have to be "iterators"
		int a = 0;
		int b = 0;
		for( ; ; a++, b--, iterate(a)) {
			if(a > 10 || b < 10) break;
		}
		//if you don't have more than one statement in the loop you don't need curly braces
		for(int i = 0; i < 10; i++, iterate(i)) System.out.println(i);
		
	}
	static void iterate(int j) {
		System.out.println(j + 1);
	}
}