package com.paniclater.inandout;

import java.io.*;

public class ListFile {
	public static void main(String[] args) {
		File here = new File(".");
		System.out.println(here.exists());
		for(String s : here.list()) System.out.println(s);
	}
}