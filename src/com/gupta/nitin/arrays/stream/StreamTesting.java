package com.gupta.nitin.arrays.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class StreamTesting {
	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Pune", "raipur", "Mumbai", "gariaband", "Mumbai", "gariaband", "Rajim",
				"Ppi", "Itarsi", "Pune", "raipur", "Mumbai", "gariaband", "Rajim");

		Stream<String> unique = cities.stream().distinct();
		/// unique.forEach(System.out::println);

		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		List<Float> productPriceList2 = productsList.stream().filter(p -> p.price > 30000)// filtering data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList2);

		Set<Float> productPriceList1 = productsList.stream().map(p -> p.price) // fetching price

				.filter(p -> p > 30000)// filtering data
				.collect(Collectors.toSet()); // collecting as list
		System.out.println(productPriceList1);

		Float totalPrice = productsList.stream().map(product -> product.price).reduce(0.0f,
				(sum, price) -> sum + price); // accumulating price

		totalPrice = productsList.stream().map(product -> product.price).reduce(0.0f, (i, j) -> i + j); // accumulating
																										// price
		System.out.println(totalPrice);
		double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		System.out.println(totalPrice3);

		// max() method to get max Product price
		Product productA = productsList.stream().max((product1, product2) -> product1.price > product2.price ? 1 : -1)
				.get();

		System.out.println("max price " + productA.price);
		// min() method to get min Product price
		Product productB = productsList.stream().max((product1, product2) -> product1.price < product2.price ? 1 : -1)
				.get();
		System.out.println("Min price " + productB.price);
		long count = productsList.stream().filter(product -> product.price < 30000).count();
		System.out.println(count);

		// Converting product List into Set
		Set<Float> productPriceList = productsList.stream().filter(product -> product.price < 30000) // filter product
																										// on the base
																										// of price
				.map(product -> product.price).collect(Collectors.toSet()); // collect it as Set(remove duplicate
																			// elements)
		System.out.println(productPriceList);
		Map<Integer, String> productPriceMap = productsList.stream().collect(Collectors.toMap(p -> p.id, p -> p.name));

		System.out.println(productPriceMap);
		
		 List<Float> productPriceList12 =   
	                productsList.stream()  
	                            .filter(p -> p.price > 30000) // filtering data  
	                            .map(Product::getPrice)         // fetching price by referring getPrice method  
	                            .collect(Collectors.toList());  // collecting as list  
	        System.out.println(productPriceList12);  
	}

	public static void main2(String[] args) {
		Stream.iterate(1, element -> element + 1).filter(element -> element % 5 == 0).limit(5)
				.forEach(System.out::println);
	}

}
