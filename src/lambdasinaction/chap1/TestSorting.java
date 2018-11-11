package lambdasinaction.chap1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Developer {

	private String name;
	private BigDecimal salary;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

}

public class TestSorting {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		// sort by age
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});

		System.out.println("After Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		// sort by name
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		System.out.println("After Sort Name");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		// sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		System.out.println("After Sort Salary");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		System.out.println("lambda here!");
		// lambda here!
	///	listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
		
		//lambda
		//listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));
		//lambda
		//listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));	
		
		/*Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
		listDevs.sort(salaryComparator);*/
		
		Comparator<Developer> nameComparator = (o1, o2)->o1.getName().compareTo(o2.getName());
		listDevs.sort(nameComparator.reversed());

		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
		
		
		

	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;

	}

}
