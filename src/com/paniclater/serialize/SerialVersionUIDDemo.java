package com.paniclater.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
	//// https://dzone.com/articles/what-is-serialversionuid
	/**
	 * There are 3 ways to define the serialVersionUID :
	 * 
	 * 1. private static final long serialVersionUID = 1L; (Default)
	 * 
	 * 2. private static final long serialVersionUID = -8940196742313994740L;
	 * (Generated)
	 * 
	 * 3. Don't define serialVersionUID and let the JVM define it at runtime. @Lance
	 * Java
	 * 
	 */
	private static final long serialVersionUID = -63033333476397989L;
	private String name;
	private byte age;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String whoIsThis() {
		StringBuffer employee = new StringBuffer();
		employee.append(getName()).append(" is ").append(getAge()).append(" years old and lives at ")
				.append(getAddress());
		return employee.toString();
	}

	public String whoIsThis1() {
		StringBuffer employee = new StringBuffer();
		employee.append(getName()).append(" is ").append(" years old and lives at ").append(getAddress());
		return employee.toString();
	}
}

public class SerialVersionUIDDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Employee employee = new Employee();
		employee.setName("Ashintha");
		employee.setAge((byte) 30);
		employee.setAddress("Galle");
		/*FileOutputStream fout = new FileOutputStream("abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(employee);
		oos.close();
		System.out.println("Process complete");*/

		/* De-Serializing B's(subclass) object */

		// Reading the object from a file
		FileInputStream fis = new FileInputStream("abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Method for de-serialization of B's class object
		Employee b2 = (Employee) ois.readObject();

		// closing streams
		ois.close();
		fis.close();

		System.out.println("Object has been deserialized");

		System.out.println(b2.whoIsThis1());

	}

}
