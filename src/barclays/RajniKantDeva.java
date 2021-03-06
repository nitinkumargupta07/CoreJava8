package barclays;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

class Person {
	public String firstName;
	public int age;

	public Person() {
	}

	public Person(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class RajniKantDeva {

	public static void main1(String[] args) {

		Person obama = new Person("Barack Obama", 53);
		Person bush2 = new Person("George Bush", 68);
		Person clinton = new Person("Bill Clinton", 68);
		Person bush1 = new Person("George HW Bush", 90);

		Person[] personArray = new Person[] { obama, bush2, clinton, bush1 };
		List<Person> personList = Arrays.asList(personArray);
		Stream<Person> sss=Arrays.stream(personArray);
		Stream<Person> sss22= personList.stream();
		// Find Oldest Person
		final Comparator<Person> comp = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
		Person oldest = personList.stream().max(comp).get();

		// Find Youngest Person
		// -This time instead create the Comparator as the argument to the min() method
		Person youngest = personList.stream().min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).get();
	}

	public static void main112(String[] args) throws ClassNotFoundException {

		String[] array = { "Geeks", "for", "Geeks45345586968234forGeeks", "GeeksQuiz" };

		Optional<String> MAX1 = Arrays.stream(array).max((str1, str2) -> Integer.compare(str1.length(), str2.length()));
		System.out.println(MAX1);
		// The result is stored in variable MAX
		Optional<String> MAX = Arrays.stream(array)
				.max((str1, str2) -> Character.compare(str1.charAt(str1.length() - 1), str2.charAt(str2.length() - 1)));
		System.out.println(MAX);
		String s = "abcabawerewrwerw";
		Map<Character, Integer> frequencies = s.chars().boxed()
				.collect(toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, // 1 occurence
						Integer::sum)); // counting
		System.out.println("Frequencies:\n" + frequencies);

		Map<Character, Long> freqqquencies = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Object, Long> frequ12encies = s.chars().boxed().collect((Collectors
				.groupingBy(k -> Character.valueOf((char) k.intValue()), LinkedHashMap::new, Collectors.counting())));
		System.out.println("Frequencies:\n" + frequ12encies);

		s.chars().boxed().collect((Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()),
				LinkedHashMap::new, Collectors.counting()))).forEach((k, v) -> System.out.print(k + "  " + v));

		s.chars().boxed().collect(Collectors.groupingBy(k1 -> Character.valueOf((char) k1.intValue()), 
		 Collectors.counting()));
	}

	public static void main56(String[] args) {
		String str = "nitin. sachin Raji. sachin Raji nitin . Raji nitin raja rahim . raja nitin . Raji";
		Map<String, List<String>> ssss = Arrays.stream(str.split("\\."))
				.collect(Collectors.groupingBy(Function.identity()));
		String[] ss = str.split("\\.");
		System.out.println(Arrays.toString(ss));
		Arrays.stream(str.split("\\.")).map(word -> new SimpleEntry<>(word ,word.split(" ").length)).max(Map.Entry.comparingByValue()).get()
		.getValue();
		
		
		// ssss.forEach((key, value) -> System.out.println ("key "+key +"
		// value"+value));
		// System.out.println(ssss);
		// String[] toks = "\"Aac 1Zl
		// Aachen\",,DE,5048.850N,00611.483E,189.0m,1,,,,\"AACHEN\"".split(",");
		/// System.out.println(Arrays.toString(toks));

	}

	public static void main4353(String[] args) {
		String str = "nitin sachin Raji sachin Raji nitin Raji nitin raja rahim raja nitin Raji";
		Long s13 = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
				.max(Comparator.comparing(a -> a)).get();
		 /////Stream<String> dddd=Stream.of(str.split(" "));


		Long s11 = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
				.max(Comparator.comparing(a -> a)).get();
		
		String ss = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().map(e -> e.getKey()).get();
		System.out.println(ss);

		Map<String, Long> mapchar = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		String ss22 = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(e -> e.getKey()).get();

		System.out.println("ss22     " + ss22);

		String sssss2 = Stream.of(str.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max((p1, p2) -> Long.compare(p1.getValue(), p2.getValue())).map(e -> e.getKey()).get();
		System.out.println("sssss2 -->>" + sssss2);

		String ss1 = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max((e1, e2) -> e1.getValue() > e2.getValue() ? -1 : 1).map(e -> e.getKey()).get();

		System.out.println(ss1);

		Map<String, Long> map = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Stream<String> s222 = Stream.of(str.split(" ")).map(elem -> new String(elem));
	}

	public static Map<Character, Integer> findMaxOChar(String text) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Character maxChar = ' ';
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < text.length(); i++) {
			Character current = text.charAt(i);
			if (map.containsKey(current)) {
				map.put(current, map.get(current) + 1);
			} else {
				map.put(current, 1);
			}
			if (map.get(current) > max) {
				maxChar = current;
				max = map.get(current);
			}
		}
		map.clear();
		map.put(maxChar, (int) max);
		return map;
	}

	public static Map<Character, Integer> findMaxOChar11(String text) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Long> map11 = text.chars().boxed()
				.collect(Collectors.groupingBy(i -> Character.valueOf((char) i.intValue()), Collectors.counting()));

		return map;

	}

	public static void main(String args[]) {
		// String text = "wfaveqr caaaaaaaaaaaafwefwgqrvwerwbhqfvwrfwvbetqfwef q fwgwfw
		// erfq";
		// System.out.println("The max character is : " + findMaxOChar(text));

		String string = "hello";
		char letter = 'l';
		long count = string.chars().filter(character -> character == letter).count();
		System.out.println(count);
	}

}
