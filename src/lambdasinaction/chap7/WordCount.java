package lambdasinaction.chap7;

import java.util.Comparator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCount {

	public static final String SENTENCE = " Nel   mezzo del cammin  di nostra  vita "
			+ "mi  ritrovai in una  selva oscura" + " chenla  dritta via era   smarrita ";

	public static void main(String[] args) {
		System.out.println("Found " + countParticularString(SENTENCE) + " times");
		System.out.println("Found " + countParticularChar(SENTENCE) + " times");
		System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
		System.out.println("Found " + countWords(SENTENCE) + " words");
	}

	private static String countParticularString(String sentence2) {
		Map<String ,Long>sddsfdsf=Stream.of(sentence2.split(" ")).collect(Collectors.groupingBy(Function.identity() ,Collectors.counting()));
		Long s=Stream.of(sentence2.split(" ")).collect(Collectors.groupingBy(Function.identity() ,Collectors.counting()))
		.values().stream().max(Comparator.comparing(a -> a)).get();
		for (Map.Entry<String, Long> map1 : sddsfdsf.entrySet()) {
			if (s == map1.getValue())
				System.out.println(map1.getKey() + "" + map1.getValue());
			
		}
		return null;
	}

	private static String countParticularChar(String sentence2) {
	Stream<Character>  ssss=sentence2.chars().mapToObj(c -> (char) c);
	long lll=ssss.filter(c -> (c.equals('N')|| c.equals('n'))).count();
	System.out.println(lll);
	
		return null;
	}

	public static int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		long sss = Stream.of(s.toCharArray()).distinct().count();

		for (char c : s.toCharArray()) {
			System.out.println(" " + c);
			System.out.println("counter :" + counter);
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace)
					counter++;
				lastSpace = Character.isWhitespace(c);
			}
		}
		return counter;
	}

	public static int countWords(String s) {
		/*
		 * Stream<Character> stream = IntStream.range(0, s.length())
		 * .mapToObj(SENTENCE::charAt).parallel();
		 */
		// Stream<Character> stream = StreamSupport.stream(spliterator, true);
		Spliterator<Character> spliterator = new WordCounterSpliterator(s);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		Stream<Character> serewrwr = s.chars().boxed().map(c -> Character.valueOf(((char) c.intValue())));
		Stream<String> sdfsf = s.codePoints().mapToObj(c -> String.valueOf((char) c));
		Stream<Character> sch = s.chars().mapToObj(i -> (char) i);
		 String s111 =  "123";
	        IntStream chars = s111.chars();
	        chars.forEach(System.out::println);
		return countWords(stream);
	}

	private static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.parallel().reduce(new WordCounter(0, true), WordCounter::accumulate,
				WordCounter::combine);
		return wordCounter.getCounter();
	}

	private static class WordCounter {
		private final int counter;
		private final boolean lastSpace;

		public WordCounter(int counter, boolean lastSpace) {
			this.counter = counter;
			this.lastSpace = lastSpace;
		}

		public WordCounter accumulate(Character c) {
			if (Character.isWhitespace(c)) {
				return lastSpace ? this : new WordCounter(counter, true);
			} else {
				return lastSpace ? new WordCounter(counter + 1, false) : this;
			}
		}

		public WordCounter combine(WordCounter wordCounter) {
			return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
		}

		public int getCounter() {
			return counter;
		}
	}

	private static class WordCounterSpliterator implements Spliterator<Character> {

		private final String string;
		private int currentChar = 0;

		private WordCounterSpliterator(String string) {
			this.string = string;
		}

		@Override
		public boolean tryAdvance(Consumer<? super Character> action) {
			action.accept(string.charAt(currentChar++));
			return currentChar < string.length();
		}

		@Override
		public Spliterator<Character> trySplit() {
			int currentSize = string.length() - currentChar;
			if (currentSize < 10) {
				return null;
			}
			for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
				if (Character.isWhitespace(string.charAt(splitPos))) {
					Spliterator<Character> spliterator = new WordCounterSpliterator(
							string.substring(currentChar, splitPos));
					currentChar = splitPos;
					return spliterator;
				}
			}
			return null;
		}

		@Override
		public long estimateSize() {
			return string.length() - currentChar;
		}

		@Override
		public int characteristics() {
			return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
		}
	}
}
