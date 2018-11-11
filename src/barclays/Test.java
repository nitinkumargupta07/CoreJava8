package barclays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Test {

	public static void main1(String[] args) throws ClassNotFoundException {
		String s = "abcabawerewrwerw";
		Map<Character, Integer> frequencies = s.chars().boxed().collect(toMap(
				k -> Character.valueOf((char) k.intValue()), 
				v -> 1, // 1 occurence
				Integer::sum)); // counting
		System.out.println("Frequencies:\n" + frequencies);
		
	////Map<Character, Long> frequencies32423 =s.chars().boxed().collect(Collectors.groupingBy(k -> Character.valueOf((Character) Function.identity().),LinkedHashMap::new,Collectors.counting()));

		Map<Object, Long> frequ12encies = s.chars().boxed().collect((Collectors
				.groupingBy(k -> Character.valueOf((char) k.intValue()), LinkedHashMap::new, Collectors.counting())));
		System.out.println("Frequencies:\n" + frequ12encies);

		s.chars().boxed().collect((Collectors.groupingBy(k -> Character.valueOf((char) k.intValue()),
				LinkedHashMap::new, Collectors.counting()))).forEach((k, v) -> System.out.print(k + "" + v));

		/// Map<Character ,Integer> frequency
		/// =s.chars().collect((Collectors.groupingBy(s -> s, LinkedHashMap::new,
		/// Collectors.counting())));
	}

	public static void main(String[] args) {
		String str = "nitin sachin Raji sachin Raji nitin Raji nitin";
		Long s = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
				.max(Comparator.comparing(a -> a)).get();
		Map<String, Long> map = Stream.of(str.split(" ")).map(elem -> new String(elem))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Map.Entry<String, Long> map1 : map.entrySet()) {
			if (s == map1.getValue())
				System.out.println(map1.getKey() + "" + map1.getValue());
			
		}

		/// test.forEach(System.out::println);
		System.out.println("count -->>" + s);

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

	public static void main234(String args[]) {
		// String text = "wfaveqr caaaaaaaaaaaafwefwgqrvwerwbhqfvwrfwvbetqfwef q fwgwfw
		// erfq";
		// System.out.println("The max character is : " + findMaxOChar(text));

		String string = "hello";
		char letter = 'l';
		long count = string.chars().filter(character -> character == letter).count();
		System.out.println(count);
	}

}
