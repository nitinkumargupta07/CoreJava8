package com.paniclater.inandout;

import java.io.*;

public class StringToFile {
	public static void main(String[] args) {
		// Be careful when constructing a string to use as a path for a file that you
		// use File.separator not File.pathSeparator
		// File.separator is the character used to separate directories in a path to a
		// file -- / in unix linux land, \ in windows
		// File.pathSeparator is the character used to separate lists of paths (the only
		// case I'm familiar with would be in setting up the
		// PATH environment variable -- : in unix linux land, ; in windows
		String fileString = ".." + File.separator + "test.txt";
		System.out.println(fileString);
		String pathString = "c:\\java" + File.pathSeparator + "C:\\python";
		System.out.println(pathString);
		File a = new File(fileString);
		try {
			a.createNewFile();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		// try to make a new directory and put a file in it
		String dirString = "newdir";
		File dirDir = new File(dirString);
		if (!dirDir.isDirectory()) {
			dirDir.mkdir();
		}
		String fileAndDir = dirString + File.separator + "newfile.txt";
		a = new File(fileAndDir);
		try {
			a.createNewFile();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}