package com.paniclater.exceptional;

import java.io.*;

public class CatchEmAll {
	public static void main(String[] args) {
		try {
			throw new Exception(); 
		} catch(Exception e) {
			try {
				throw new IOException();
			} catch (IOException ioe) {
				try {
					throw new FileNotFoundException();
				} catch (FileNotFoundException fnfe) {
					try {
						throw new ClassNotFoundException();
					} catch (ClassNotFoundException cnfe) {
						try {
							throw new CloneNotSupportedException();
						} catch (CloneNotSupportedException cnse) {
							try {
								throw new InstantiationException();
							} catch (InstantiationException ie) {
								try {
									throw new NoSuchMethodException();
								} catch (NoSuchMethodException nsme) {
									try {
										throw new NoSuchFieldException(); 
									} catch (NoSuchFieldException nsfe) {
									
									}	
								}	
							}
						}
					}
				}
			}
		}
	}
}