package com.paniclater.polymorphism.subpackage;

import java.io.FileNotFoundException;

import com.paniclater.polymorphism.Animal;

public class OverridingPackageTest extends Animal{
	
	@Override
	public void drink() throws FileNotFoundException, NullPointerException {
		// TODO Auto-generated method stub
		super.drink();
	}

}
