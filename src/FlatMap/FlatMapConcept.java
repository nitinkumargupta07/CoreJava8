package FlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.madhusudhan.wr.allaboutlambdas.domain.Student;

public class FlatMapConcept {
	/**
	 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
	 * 
	 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
	 * 
	 * @param args
	 */
	public static void main1(String[] args) {
		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" },
				{ "s", "d", "f", "g", "h", "j", "k", "l" } };
		Stream<String[]>	ss=Stream.of(data);
		Stream.of(data).flatMap(s ->Arrays.stream(s)).collect(Collectors.groupingBy(Function.identity()  ,Collectors.counting()));
		int[][] intData = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 1, 4, 5, 7, 9, 10 }, { 34, 33, 54 } };
		Stream<String[]> temp = Arrays.stream(data);
		// filter a stream of string[], and return a string[]?
		Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
		stream.forEach(System.out::println);
		/// Output //empty...

		// Stream<String>, GOOD!
		Stream<String[]> temp1 = Arrays.stream(data);
		Stream<String> stringStream = temp1.flatMap(x -> Arrays.stream(x));
		/// stringStream.forEach(System.out::print);
		stringStream.forEach(x -> System.out.print("  " + x));
	}

	public static void main2(String[] args) {
		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);

		List<String> collect = list.stream().map(x -> x.getBook()).flatMap(x -> x.stream()).distinct()
				.collect(Collectors.toList());
		collect.forEach(x -> System.out.println(x));
	}

	public static void main(String[] args) {

		int[] intArray = { 1, 2, 3, 4, 5, 6 };
		List<int[]> list = Arrays.asList(intArray);
		IntStream intArray1 = Arrays.stream(intArray);

		Stream<int[]> streamArray1 = Arrays.asList(intArray).stream();
		// 1. Stream<int[]>
		Stream<int[]> streamArray = Stream.of(intArray);

		// 2. Stream<int[]> -> flatMap -> IntStream
		IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

		intStream.forEach(x -> System.out.println(x));

	}

}
