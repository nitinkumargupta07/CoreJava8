package com.paniclater.enums.subpackage;

class EnumExtendsTest {

}

interface EnumIntrface{
	void go();
}

public enum shape implements EnumIntrface{
	CIRCLE ,RECTANGLE;
	@Override
	public void go() {
		// TODO Auto-generated method stub
		
	}
	
}
// The type EnumExtendsTest cannot be a superinterface of Color; a
// superinterface must be an interface
/*
 * interface Color extends EnumExtendsTest{
 * 
 * }
 */

interface Color {

}

enum CarColor implements Color {
	BLUE, GREEN;
}


enum RacingCarColor implements Color {
	BLUE, GREEN, YELLOW;
}

class Vehicle<T extends Color> {
	protected T color;

	protected Vehicle(T color) {
		this.color = color;
	}

	public T getColor() {
		return color;
	}
}

class Car extends Vehicle<CarColor> {
	public Car(CarColor color) {
		super(color);
	}
}

class RacingCar extends Vehicle<RacingCarColor> {
	public RacingCar(RacingCarColor color) {
		super(color);
	}
}