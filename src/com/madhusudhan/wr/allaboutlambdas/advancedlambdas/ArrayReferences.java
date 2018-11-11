package com.madhusudhan.wr.allaboutlambdas.advancedlambdas;

import java.util.Arrays;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;

/**
 * Class that shows us how to use array references
 * @author mkonda
 *
 */
public class ArrayReferences {
	// Interface creating an array of Strings
	interface StringArray {
		String[] create(int size);
	}

	// Lambda without references
	StringArray sArrayLambda = (size) -> new String[size];

	StringArray sArrayLambdaMethodRef = String[]::new;

	// Trades array
	interface TradeArray {
		Trade[] create(int size);
	}

	// Lambda using array references
	TradeArray tradesLambdaMethodRef = Trade[]::new;
	TradeArray tradesLambda = (size) -> new Trade[size]; 
	

	private void arrayReference(int size) {
		String[] softDrinks = sArrayLambda.create(10);
		Arrays.stream(softDrinks).forEach(System.out::println);
	}
	private void arrayReference1(int size) {
		String[] softDrinks = sArrayLambdaMethodRef.create(10);
		Arrays.stream(softDrinks).forEach(System.out::println);
	}
	private void arrayReference2(int size) {
		Trade[] softDrinks = tradesLambdaMethodRef.create(10);
		Arrays.stream(softDrinks).forEach(System.out::println);
	}
	public static void main(String[] args) {
		ArrayReferences arrayReferences=new ArrayReferences();
		arrayReferences.arrayReference(10);
		

	}
}
