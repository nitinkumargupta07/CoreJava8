package com.gupta.nitin.arrays;

public class MultiDim {
	public static void main(String[] args) {
	//when creating a multidimensional array each bracket refers to the size of that dimension.
	int[][] multi;
	multi = new int[3][3];
	int[] kid = {0, 1, 2};
	multi[0] = kid;
	kid = new int[2];
	int count = 0;
	for( int i : kid ) kid[i] = ++count; 
	multi[1] = kid;
	kid = new int[10];
	for( int i : kid ) kid[i] = ++count;
	multi[2] = kid;
	kid = new int[2];
	for(int[] a : multi) {
		for(int b : a) {
		System.out.println(b);
		}
	}
	//to create a new multidimensional array if you don't specify the size of the outer level at initialization there will be a compiler error
	//int[][] multi2 = new int[][]; WILL NOT COMPILE
	
	//it is ok to not initialize the "child" arrays in a multidimensional array. This way you can specify child array size at each initialization.
	int[][][] multi3 = new int[2][][];
	int[][] multi1 = new int[2][];
	multi1[0] = new int[10];
	multi1[1] = new int[29];
	}
}