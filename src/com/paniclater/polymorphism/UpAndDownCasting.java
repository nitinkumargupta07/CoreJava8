package com.paniclater.polymorphism;

public class UpAndDownCasting {
	double ddd;

	public static void main(String[] args) {
		UpAndDownCasting casting=new UpAndDownCasting();
		int a =100 ,b=200;
		int a11q=Integer.MAX_VALUE;
		short sdsd=(short) a11q;
		short a11 =(short) a;
		//Up casting no issue
		double d=casting.add(a, b);
		//If you down cast use explicit; 
		int c= (int) casting.add(a, b);
		
		short sa =10 ,sb=40;
		add1(sa ,sb);
		double da=10.99 ,db=99.99;
		//Explict down casting is required
		add1((int)da, (int)db);
		
	}
	
	public double add(double d ,double c) {
		return d+c;
	}
	public static int  add1(int d ,int c) {
		return d+c;
	}

}
