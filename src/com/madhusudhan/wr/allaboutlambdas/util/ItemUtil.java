package com.madhusudhan.wr.allaboutlambdas.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.madhusudhan.wr.allaboutlambdas.domain.Item;

public class ItemUtil {
	public static List<Item> createItem() {
		List<Item> items = new ArrayList<>();
		Item item1 = new Item(1, "banana", new BigDecimal(12.75), 12);
		Item item2 = new Item(2, "banana1", new BigDecimal(13.75), 2);
		Item item3 = new Item(3, "banana2", new BigDecimal(14.75), 1);
		Item item4 = new Item(4, "banana3", new BigDecimal(15.75), 122);
		Item item5 = new Item(5, "banana4", new BigDecimal(16.75), 123);
		Item item6 = new Item(6, "banana5", new BigDecimal(17.75), 412);
		Item item7 = new Item(7, "banana6", new BigDecimal(18.75), 612);
		Item item8 = new Item(8, "banana7", new BigDecimal(19.75), 712);
		Item item9 = new Item(9, "banana8", new BigDecimal(129.75), 912);
		Item item10 = new Item(10, "banana9", new BigDecimal(112.75), 912);
		Item item18 = new Item(8, "banana7", new BigDecimal(17.75), 712);
		Item item19 = new Item(9, "banana8", new BigDecimal(17.75), 912);
		Item item110 = new Item(10, "banana9",new BigDecimal(17.75), 912);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item10);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item110);
		items.add(item18);
		items.add(item19);
		items.add(item7);
		return items;
	}
}
