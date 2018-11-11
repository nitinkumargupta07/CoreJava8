package com.gupta.nitin.comparing;

import java.util.Arrays;
import java.util.Comparator;
public class Zoom {
	private int size;
	private String name;

	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	} 	
	public void setSize(int size) {
		this.size = size;
	}
	public Zoom(int size) {
		this.size = size;
	}
	public Zoom(int size, String name) {
		this(size);
		this.name = name;
	}
	public static void main(String[] args) {
		Zoom[] za = {new Zoom(500), new Zoom(1), new Zoom(50), new Zoom(-40)};
		Zoom[] zna = {new Zoom(500, "Charlie"), new Zoom(29,"Amy"), new Zoom(-50, "B3ck")};
		for(Zoom z : za) {
			System.out.print(" " + z.getSize() + " ");
		}
		System.out.println("\n");
		Boom b = new Boom();
		Voom v = new Voom();
		System.out.println(b.compare(new Zoom(500), new Zoom(1)));
		System.out.println(v.compare(new Zoom(500), new Zoom(1)));
		Arrays.sort(za, b);
		for(Zoom z : za) {
			System.out.print(" " + z.getSize() + " ");
		}
		System.out.println("\n");
		Arrays.sort(za, v);
		for(Zoom z : za) {
			System.out.print(" " + z.getSize() + " ");
		}
		System.out.println("\n");

		for(Zoom z : zna) {
			System.out.print(" " + z.getSize() + " " + z.getName() + " ");
		}
		System.out.println("\n");
		Arrays.sort(zna, b);
		for(Zoom z : zna) {
			System.out.print(" " + z.getSize() + " " + z.getName() + " ");
		}
		System.out.println("\n");
		Arrays.sort(zna, new NameSort());
		for(Zoom z : zna) {
			System.out.print(" " + z.getSize() + " " + z.getName() + " ");
		}
		System.out.println("\n");
	}
}
//Boom's compare should return smallest to largest
class Boom implements Comparator<Zoom> {
	public int compare(Zoom a, Zoom b) {
		return ((Integer) a.getSize()).compareTo(b.getSize());
	}	
}
//Voom's compare should return largest to smallest
class Voom implements Comparator<Zoom> {
	public int compare(Zoom a, Zoom b) {
	return b.getSize() - a.getSize();	
	}
}
//NameSort compare sorts by name
class NameSort implements Comparator<Zoom> {
	public int compare(Zoom a, Zoom b) {
		return a.getName().compareTo(b.getName());
	}		
}