package com.paniclater.inandout;
import java.io.*;

public class TestOverloadCreate {
	public static void main(String[] args) {
		File dir = new File("testDir");
		//why is making a directory not risky enough to require a try catch, but making a file is?
		dir.mkdir();
		File file = new File(dir, "testFile.txt");
		try {	
			file.createNewFile();
			//throw new IOException();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
