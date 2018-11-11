package lambdasinaction.chap7;

import java.time.LocalTime;
import java.util.OptionalLong;
import java.util.stream.*;

public class ParallelStreams {

	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 0; i <= n; i++) {
			result += i;
		}
		return result;
	}

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
	}

	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
	}

	public static long rangedSum(long n) {
		OptionalLong ssss = LongStream.rangeClosed(1, n).findAny();
		System.out.println(ssss);
		return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
	}

	public static long parallelRangedSum(long n) {
		LongStream.rangeClosed(1, n).parallel()
				.forEach(c -> System.out.println(" " + LocalTime.now() + " " + Thread.currentThread().getName()));
		return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
	}

	public static long sideEffectSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).forEach(accumulator::add);
		return accumulator.total;
	}

	public static long sideEffectParallelSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		LongStream.rangeClosed(1, n).boxed().forEach(accumulator::add);
		return accumulator.total;
	}

	public static class Accumulator {
		private long total = 0;

		public void add(long value) {
			total += value;
		}
	}

	public static void main(String[] args) {
		System.out.println("sideEffectParallelSum " + sideEffectParallelSum(10));
		System.out.println("sideEffectSum  " + sideEffectSum(10));
		System.out.println("iterativeSum  " + iterativeSum(10));
		System.out.println("sequentialSum  " + sequentialSum(10));
		System.out.println("parallelSum  " + parallelSum(10));
		System.out.println("rangedSum  " + rangedSum(10));
		System.out.println("parallelRangedSum  " + parallelRangedSum(10));
	}
}
