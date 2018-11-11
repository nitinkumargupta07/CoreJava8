package com.paniclater.exceptional;

import java.text.*;
import java.lang.InterruptedException;

public class Finally {
//unchecked errors / exceptions
//ArrayIndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//IllegalStateException
//NullPointerException
//NumberFormatException
//AssertionError
//ExceptionInInitializerError
//StackOverflowError
//NoClassDefFoundError

//checked expetions
//Exception
//IOException
//FileNotFoundException
//ParseException
//ClassNotFoundException
//CloneNotSuppertedException
//InstantiationException
//InterruptedException
//NoSuchMethodException
//NoSUchFieldException

	public static void main(String[] args) {
		//wrap checked Exception in try catch
		try {
			System.out.println("Try");
			throw new ParseException("hello", 5);			
		} catch (Exception e) {
			System.out.println("Catch ParseException");
			System.out.println(e);
		} finally {
			System.out.println("Finally");
			String[] small = { "1", "2", "3", "4", "5" };
			//cause unchecked exception ArrayIndexOutOfBoundsException
			System.out.println(small[5]);
			//since there is no code to handle the above exception, no other code will run.
			System.out.println("Finished Finally");
		}	
		System.out.println("Out of the danger zone");	
	}

}




