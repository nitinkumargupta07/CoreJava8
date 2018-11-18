package com.paniclater.exceptional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

////https://www.journaldev.com/592/java-try-with-resources
/**
 * @author nitin
 */
class Java6ResourceManagement {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\workspace\\CoreJava8\\README.md"));
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

/**
 * 1 . More readable code and easy to write.
 * 
 * 2. Automatic resource management.
 * 
 * 3. Number of lines of code is reduced.
 * 
 * 4. No need of finally block just to close the resources. We can open multiple
 * resources in try-with-resources statement separated by a semicolon.
 * 
 * 5. When multiple resources are opened in try-with-resources, it closes them
 * in the reverse order to avoid any dependency issue. You can extend my
 * resource program to prove that.
 * 
 * Java 7 has introduced a new interface java.lang.AutoCloseable. To use any
 * resource in try-with-resources, it must implement AutoCloseable interface
 * else java compiler will throw compilation error.
 * 
 * @author nitin
 *
 */
public class Java7ResourceManagement {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\workspace\\CoreJava8\\README.md"))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Java7ResourceManagement1 {

	public static void main(String[] args) {

		try (MyResource mr = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Out of try-catch block.");
	}

	static class MyResource implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
		}

	}
}

/**
 * Java SE 7: Try-With-Resources Rules In Java SE 7 or 8 versions, we should
 * follow these rules to use Try-With-Resources statement for Automatic Resource
 * Management(ARM)
 * 
 * Any Resource (which Pre-defined Java API class or User Defined class) must
 * implement java.lang.AutoCloseable. Resource object must refer either final or
 * effectively final variable If Resource is already declared outside the
 * Try-With-Resources Statement, we should re-refer with local variable (As
 * shown in the above Example-1 code) That newly created local variable is valid
 * to use within Try-With-Resources Statement.
 */
class Java7ResourceManagement2 {

	public static void main(String[] args) throws Exception {
		try {
			tryWithResourceException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			normalTryException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void normalTryException() throws Exception {
		MyResource mr = null;
		try {
			mr = new MyResource();
			System.out.println("MyResource created in try block");
			if (true)
				throw new Exception("Exception in try");
		} finally {
			if (mr != null)
				mr.close();
		}

	}

	private static void tryWithResourceException() throws Exception {
		try (MyResource mr = new MyResource()) {
			System.out.println("MyResource created in try-with-resources");
			if (true)
				throw new Exception("Exception in try");
		}
	}

	static class MyResource implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
			throw new Exception("Exception in Closing");
		}

	}
}
