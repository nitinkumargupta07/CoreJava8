package com.gupta.nitin.collections;

import java.util.*;

public class Mapit {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Integer i1 = 45;
		Integer i2 = 46;
		set.add(i1);
		set.add(null);
		// straightforward enough -- you can't have non-unique values in a set, so when
		// you try to add i1
		// you the method returns false and you still have 1 element
		set.add(i1);
		// now that you add i2 you have 2 elements. So far so good.
		set.add(i2);
		System.out.print(set.size() + " ");
		// now that you remove i1 you have one element left -- an Integer wrapper object
		// holding a bit value of 46,
		// referred to by reference var i2
		set.remove(i1);
		System.out.print(set.size() + " ");
		// This where it gets tricky -- i2 is of type Integer not int. So when you say
		// i2 = integer literal 47 the compiler
		// does some wrapping up for you under the hood
		i2 = 47;
		// is the equivalent of i2 = new Integer.valueOf(47); This means that the
		// reference var that was pointing to the
		// Integer object with the value of 46 is now pointing at a new object. When you
		// try to remove this new object from
		// the set the jvm sees that it does not exist and doesn't remove anything --
		// set.remove(i2) returns false.
		// Thus size is still one, with an Integer object of value int primitive 46.
		set.remove(i2);
		System.out.print(set.size() + " \n");
		// in order to remove the item you would need to make a copy of the object and
		// reassign it to i2 or pass it directly
		i2 = 46;
		// or
		i2 = Integer.valueOf(46);
		// or
		System.out.println(set.remove(Integer.valueOf(46)));
		System.out.println(set.remove(i2));
		// all of the above work when run. You just need to remember that when you look
		// up an item in a hash collection you
		// are doing so by passing in a copy of the object such as equals() && hashCode
		// return the same !!
		System.out.println(set.size() + "");
	}
}
