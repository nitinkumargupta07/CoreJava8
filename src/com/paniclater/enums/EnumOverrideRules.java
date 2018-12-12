package com.paniclater.enums;

import com.paniclater.enums.Car.CarColors;

/**
 * If I have a class that contains an enum type, can I extend this class and
 * override the enum type or add more constants to this enum?
 */
class Car {
	private String name;
	private CarColors color;

	public enum CarColors {
		BLUE, GREEN
	}

	public Car() {}
	public Car(CarColors c) {
		color = c;
	}

	public CarColors getColor() {
		return color;
	}
}

class RacingCar extends Car {

    private CarColors color;
    public RacingCar() {}
    public RacingCar(CarColors c) {
    	super();
        color=c;
    }

    public enum CarColors {
        BLUE,
        GREEN,
        RED
    }

   /* @Override
    public CarColors getColor() {
        return color;
    }*/
}
public class EnumOverrideRules {
public static void main(String[] args) {
	Car racingCar = new RacingCar();
	CarColors color = racingCar.getColor();
}
}
