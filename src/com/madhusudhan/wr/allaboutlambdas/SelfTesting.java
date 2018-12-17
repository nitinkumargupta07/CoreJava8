package com.madhusudhan.wr.allaboutlambdas;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.madhusudhan.wr.allaboutlambdas.domain.Item;
import com.madhusudhan.wr.allaboutlambdas.util.ItemUtil;

public class SelfTesting {
	static List<Item> items = ItemUtil.createItem();

	public static void main(String[] args) {
		/*
		 * Map<BigDecimal, Set<String>> result = items.stream()
		 * .collect(Collectors.groupingBy(Item::getPrice,
		 * Collectors.mapping(Item::getName, Collectors.toSet()))); result.forEach((k,
		 * v) -> System.out.println(k + " " + v));
		 * 
		 * Map<BigDecimal, List<String>> result2 = items.stream()
		 * .collect(Collectors.groupingBy(Item::getPrice,
		 * Collectors.mapping(Item::getName, Collectors.toList()))); result2.forEach((k,
		 * v) -> System.out.println(k + " " + v));
		 */

		/*
		 * Map<Item, Item> map =
		 * items.stream().collect(Collectors.toMap(Function.identity(), s->s ));
		 * map.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));
		 */
		// Exception in thread "main" java.lang.IllegalStateException: Duplicate key
		// Item [id=5, name=banana4, price=16.75, quantity=123]
		Map<BigDecimal, String> result3 = items.stream()
				.collect(Collectors.toMap(Item::getPrice, Item::getName, (s, a) -> s + ", " + a));
		result3.forEach((k, v) -> System.out.println(k + " " + v));

		Map<Integer, String> map = items.stream()
				.collect(Collectors.toMap(Item::getQuantity, Item::getName, (x, y) -> x + ", " + y));
		map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));
		Map<Integer, String> map1 = items.stream().collect(
				Collectors.toMap(Item::getQuantity, Item::getName, (x, y) -> x + ", " + y, LinkedHashMap::new));
		map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));

		/*
		 * Map<BigDecimal, List<Item>> result1 =
		 * items.stream().collect(Collectors.groupingBy(Item::getPrice));
		 * Map<BigDecimal, List<Item>> result2 = items.stream()
		 * .collect(Collectors.groupingBy(Item::getPrice, Collectors.toList()));
		 * Map<BigDecimal, Item> result4 =
		 * items.stream().collect(Collectors.toMap(Item::getPrice, Item -> Item));
		 * Map<BigDecimal, String> toMapuse = items.stream()
		 * .collect(Collectors.toMap(Item::getPrice, Item::getName, (s, a) -> s + ", " +
		 * a)); ///toMapuse.forEach((k, v) -> System.out.print(k + "  " + v));
		 */
	}
}
