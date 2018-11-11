package com.paniclater.exceptional;

public class StateBadBoy {
	public static void main(String[] args) {
		Car car = new Car();
		car.start();
		try {
			car.fillTank();	
		} catch (IllegalStateException ise) {
			System.out.println(ise);
		}
		car.stop();
		try {
			car.fillTank();	
			System.out.println("Tank full");
		} catch (IllegalStateException ise) {
			System.out.println(ise);
		}
		try {
			car.fillTank();	
			System.out.println("Tank full");
		} catch (IllegalStateException ise) {
			System.out.println(ise);
		}
	}
}

class Car {
	boolean running;
	boolean full;
	Car() {
		running = false;
		full = false;
	}
	void fillTank() {
		if(running) {
			throw new IllegalStateException("Turn off the car before filling tank, dummy!");
		} else if(full) {
			throw new IllegalStateException("Tanks already full, dummy!");
		} else {
			full = true;
		}
	}
	void start() {
		running = true;
		full = false;
	}
	void stop() {
		running = false;
	}

}