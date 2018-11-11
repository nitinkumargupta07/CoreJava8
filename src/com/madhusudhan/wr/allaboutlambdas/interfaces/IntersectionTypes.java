package com.madhusudhan.wr.allaboutlambdas.interfaces;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Class demonstrating the intersection types.
 * @author mkonda
 *
 */
public class IntersectionTypes {

	// Marker interface (no methods)
	interface Shape {
	}

	/**
	 * A functional interface
	 * @author mkonda
	 *
	 */
	@FunctionalInterface
	interface Ball {
		void bounce();
	}
	
	Ball b = () -> System.out.println("Bouncing..");
	
	Ball ball = 
			 (Ball & Shape)() -> System.out.println("Bouncing shape..");
			 
	Ball serializableBallLambda = (Ball&Serializable)() -> System.out.println("Bouncing serializable ball"); 
	
	Function<Integer,Integer> add1 = x -> x + 1;
	Function<String,String> concat = x -> x + 1;
	BiFunction<Integer,Integer,Integer> biFunction=(x ,y) -> x*y;
	
	public static void main(String[] args) {
		IntersectionTypes intersectionTypes=new IntersectionTypes();
		intersectionTypes.testLambdaExp();
	}

	private void testLambdaExp() {
		b.bounce();
		ball.bounce();
		serializableBallLambda.bounce();
		System.out.println(add1.apply(10));
		System.out.println(concat.apply("nitin"));
		System.out.println(biFunction.apply(10, 20));
	}
}
