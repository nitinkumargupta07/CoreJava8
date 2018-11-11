package com.paniclater.inandout;

import java.io.*;

public class Finder {
	public static void main(String[] args) throws IOException {
		String[] files = new String[100];
		File dir = new File(args[0]);
		files = dir.list();
		System.out.println(files.length);
	}
}
