package PrectiseJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;

public class LambdaConcept {
	/**
	 * Important points about Stream to array conversion
	 * 
	 * 1. The java.util.stream.Stream class provides toArray() method to convert a
	 * Stream to array in Java. This method is overloaded to return an object array
	 * and an array of type T.
	 * 
	 * 
	 * 2. You can use lambda expression or constructor reference to convert a Stream
	 * of T into array of T e.g. toArray(x -> new int[x]) will convert Stream of int
	 * to int[]. Similarly, toArray(x -> String[x]) will convert Stream of String to
	 * String array.
	 * 
	 * 
	 * 3. The best way to convert a Stream to an array in Java 8 is by using
	 * constructor reference i.e. toArray(int[]::new), this will convert Stream to
	 * int array. The int[]::new is a constructor reference and it is similar to a
	 * method which expects an integer and returns an int[]. It is equivalent to x
	 * -> int[x] lambda expression, but it's slightly easier to read and write.
	 * 
	 * 4. You can also convert Stream to an array by first converting it into an
	 * ArrayList. For that, you can use the collect() method to accumulate stream
	 * elements into a Collection e.g. ArrayList. The Collectors.toList() method
	 * will return a list of Stream elements but type of list is not guaranteed. If
	 * you want an ArrayList, just use Collectors.toCollection() method with
	 * constructor reference e.g. Collectors.toCollection(ArrayList::new))
	 * 
	 * 5. You can use same ways to convert a parallel stream to array as well.
	 * 
	 * 6. The Stream.toArray() method performs a terminal operator on Stream, hence
	 * you cannot reuse the Stream after calling this method. Any attempt to reuse
	 * Stream after calling toArray() will throw the following error:
	 * 
	 * Exception in thread "main" java.lang.IllegalStateException: stream has
	 * already been operated upon or closed
	 * 
	 * 7. If you a Stream of Integer but you want to convert them into int[] and not
	 * Integer[], then you can use the mapToInt() function to convert Integer to int
	 * before converting Stream to array in Java as shown below:
	 * 
	 * Read more:
	 * https://javarevisited.blogspot.com/2017/01/3-ways-to-convert-java-8-stream-to-array.html#ixzz5XtGdD1Rr
	 * 
	 * @param args
	 */
	public static void main23223(String[] args) {

		// stream to object array in Java
		Stream<String> currencies = Stream.of("INR", "USD", "GBP", "EUR", "JPY");
		Object[] objectArray = currencies.toArray();
		System.out.println("Stream to object array in Java:");
		System.out.println(Arrays.toString(objectArray));

		String[] StringArray = Stream.of("INR", "USD", "GBP", "EUR", "JPY").toArray(String[]::new);
		System.out.println("Stream to object array in Java:");
		System.out.println(Arrays.toString(StringArray));

		// via - Stream.toArray() and lambda expression
		Integer[] primes = { 2, 3, 5, 7, 11 };

		List<Integer> listOfInts = new ArrayList<>(Arrays.asList(primes));
		Integer[] array = listOfInts.stream().toArray(size -> new Integer[size]);
		System.out.println("Stream to Integer array using lambda expression in Java:");
		System.out.println(Arrays.toString(array));

		// via - method reference
		array = listOfInts.stream().toArray(Integer[]::new);
		System.out.println("Stream to Integer array using method reference in Java:");
		System.out.println(Arrays.toString(array));

		// via arraylist
		ArrayList<Integer> list = listOfInts.stream().collect(Collectors.toCollection(ArrayList::new));
		Integer[] iArray = list.toArray(new Integer[list.size()]);
		System.out.println("Stream to Integer array via ArrayList in Java:");
		System.out.println(list);
	}

	public static void main2(String[] args) {
		Comparator<String> strlenComp = (a, b) -> Integer.compare(a.length(), b.length());
		method1();
		// Java 8 way:
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
		Runnable runs = () -> System.out.println("Hello Lambda Expressions");
		JButton show = new JButton("Show");
		// Java 8 way:
		show.addActionListener((e) -> {
			System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
		});
		System.out.println();
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Jate", "Date and Time API");
		features.forEach(n -> System.out.println(n));

		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;

		features.stream().filter(startsWithJ.and(fourLetterLong))
				.forEach((n) -> System.out.print("\nName, which starts with 'J' and four letter long is : " + n));
		List<Double> costBeforeTax = Arrays.asList(100d, 200d, 300d, 400d, 500d);
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();

		List<String> filtered = features.stream().filter(x -> x.length() > 2).collect(Collectors.toList());

		// reduce() method from Stream API to reduce all numbers into one
		// reduce() which can combine all values into one.
		/**
		 * reduce is also known as fold operation because of its folding nature. By the
		 * way reduce is not a new operation. If you can recall SQL aggregate functions
		 * like sum(), avg() or count(), they are actually reduce operation because they
		 * accept multiple values and return a single value. Stream API defines reduce()
		 * function which can accept a lambda expression, and combine all values. Stream
		 * classes like IntStream has built-in methods like average(), count(), sum() to
		 * perform reduce operations
		 */
		System.out.println("***************************************");
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);

		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		//// List<Integer> distinct = numbers.stream().distinct().map(i ->
		//// i*i)collect(Collectors.toList());
		System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);

		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());

		List<Integer> prime2323s = Arrays.asList(new Integer[] { 2, 3, 5, 7 });
		int factor = 2;
		prime2323s.forEach(element -> {
			System.out.println(factor);
		});
		/// prime2323s.forEach(element -> { factor++; });
		/**
		 * Compile time error : "local variables referenced from a lambda expression
		 * must be final or effectively final"
		 */

		Stream<Integer> powerOfTen = Stream.of(1, 10, 100, 1000, 10000);
		Integer[] array = powerOfTen.toArray(size -> new Integer[size]);
		System.out.println(Arrays.toString(array));
		int[] intArray = Stream.of(1, 10, 100, 1000, 10000).mapToInt(x -> x).toArray();
		System.out.println(Arrays.toString(intArray));
		/**
		 * Suppose, you have a Stream of String which is numbers e.g. "1", "2", or "3"
		 * then also you can use mapToInt() to first convert String to int and then into
		 * an int array as shown below:
		 * 
		 */
		Stream<String> numb11ers = Stream.of("1", "2", "3", "4", "5");
		int[] ints = numb11ers.mapToInt(Integer::parseInt).toArray();
		System.out.println(Arrays.toString(ints));
		// Let's convert a Stream of String object into a String array
		Stream<String> cities = Stream.of("London", "Paris", "Tokyo");
		String[] arrayOfCities = cities.toArray(String[]::new);
		System.out.println(Arrays.toString(arrayOfCities));
		// Let's convert a Stream of String object into a String List
		Stream<Integer> numberss = Stream.of(11, 22, 33, 44, 55);
		ArrayList<Integer> list = numberss.collect(Collectors.toCollection(ArrayList::new));
		Integer[] iArray = list.toArray(new Integer[list.size()]);
		System.out.println(Arrays.toString(iArray));

	}

	static void method1() {
		// In Java 8
		System.out.println("Sorting List of String by length in Java 8 ======");
		List<String> cities = new ArrayList<>(Arrays.asList("London", "Tokyo", "NewYork"));
		System.out.println("The original list without sorting");
		System.out.println(cities);
		cities.sort((first, second) -> Integer.compare(first.length(), second.length()));
		System.out.println("The same list after sorting string by length");
		System.out.println(cities);
	}

	public static void main(String args[]) {
		List<Employee> peoples = new ArrayList<>();
		peoples.add(new Employee(101, "Victor", 23));
		peoples.add(new Employee(102, "Rick", 21));
		peoples.add(new Employee(103, "Sam", 25));
		peoples.add(new Employee(104, "John", 27));
		peoples.add(new Employee(105, "Grover", 23));
		peoples.add(new Employee(106, "Adam", 22));
		peoples.add(new Employee(107, "Samy", 224));
		peoples.add(new Employee(108, "Duke", 29));
		double average = calculateAverage(peoples);
		System.out.println("Average age of employees are (classic way) : " + average);
		average = average(peoples);
		System.out.println("Average age of employees are (lambda way) : " + average);
	}

	/**
	 * * Java Method to calculate average from a list of object without using *
	 * lambdas, doing it on classical java way. * @param employees * @return average
	 * age of given list of Employee
	 */
	private static double calculateAverage(List<? extends Employee> employees) {
		int totalEmployee = employees.size();
		double sum = 0;
		for (Employee e : employees) {
			sum += e.getAge();
		}
		double average = sum / totalEmployee;
		return average;
	}

	/**
	 * * Java method which uses map reduce to calculate average of list of employees
	 * * in JDK 8. * @param peoples * @return average age of given list of Employees
	 */
	private static double average(List<? extends Employee> peoples) {
		return peoples.stream().mapToInt(p -> p.getAge()).average().getAsDouble();
	}

}

class Employee {
	private final int id;
	private final String name;
	private final int age;

	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
