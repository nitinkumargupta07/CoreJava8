package com.paniclater.flow;

public class WeirdForDoWhile {
	public static void main(String[] args) {
		for(int x = 0, y = 5, z = 30; y < 10; z++) {
			y++;
			System.out.println("yo");
		}
		//if you want to use a variable that you don't declare in the flow control you must declare it outside of flow control and block.
		int z = 0;
		System.out.println(z);
		//can't add z to the instantiation portion of the block because it has already been instantiated in main.
		//you can ref it in the otehr sections
		for(int x = 0, y = 5; z < 10; y++) {
			z++;
			System.out.println("yo");
			System.out.println(z);
		}
	}

}