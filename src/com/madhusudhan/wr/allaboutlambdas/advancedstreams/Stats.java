package com.madhusudhan.wr.allaboutlambdas.advancedstreams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.madhusudhan.wr.allaboutlambdas.domain.Trade;
import com.madhusudhan.wr.allaboutlambdas.util.TradeUtil;

import static java.util.stream.Collectors.summarizingInt;

public class Stats {
	IntStream streamOfInts = IntStream.range(1, 100);

	private void summaryOfTrades() {
		List<Trade> trades = TradeUtil.createTrades();
		IntSummaryStatistics s = trades
			.stream()
			.collect(summarizingInt(Trade::getQuantity));
		System.out.println(s);
	}
	
	private void usingRange() {
		IntStream ints = IntStream.range(10, 20);
		System.out.println();
		ints.forEach(s -> System.out.print(s+","));
	}
	
	private void usingRangeClosed() {
		IntStream ints = IntStream.rangeClosed(10, 20);
		System.out.println();
		ints.forEach(s -> System.out.print(s+","));
	}
	//Min, Max and Average
	private void minMaxAndAverage() {
		IntStream ints = IntStream.rangeClosed(10, 20);
		OptionalInt max = ints.max();
		System.out.println("Max: "+max.getAsInt());
		
		ints = IntStream.rangeClosed(10, 20);
		OptionalInt min = ints.min();
		System.out.println("Min: "+min.getAsInt());
		
		ints = IntStream.rangeClosed(10, 20);
		OptionalDouble avg = ints.average();
		System.out.println("Min: "+avg.getAsDouble());
		
		
	}

	public static void main(String[] args) {
		Stats stats=	new Stats();
		stats.summaryOfTrades();
		stats.usingRange();
		stats.usingRangeClosed();
		stats.minMaxAndAverage();
	}
}
