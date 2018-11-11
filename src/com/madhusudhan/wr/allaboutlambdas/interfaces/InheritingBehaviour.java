package com.madhusudhan.wr.allaboutlambdas.interfaces;
/**
 * A class that shows us how we can inherit behavior implementing various default methods  
 * @author mkonda
 *
 */
public class InheritingBehaviour {

	/**
	 * An Engine interface
	 * @author mkonda
	 *
	 */
	interface Engine {
		default String make() {
			return "DEFAULT MAKE";
		}
		 String make1() ;
	}

	interface Vehicle {
		default String model() {
			return "DEFAULT MODEL";
		}
		String model1();
	}

	class Car implements Engine, Vehicle {

		@Override
		public String model1() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String make1() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getMakeAndModel() {
			return Engine.super.make() + ":" + Vehicle.super.model();
		}
	}
}
