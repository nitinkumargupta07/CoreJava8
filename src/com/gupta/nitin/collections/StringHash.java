package com.gupta.nitin.collections;
import java.util.*;

public class StringHash {
	public static void main(String[] args) {
		//Class String overrides equals and hashCode out of the box so you are ok using it in HashSets or other
		//collections that use Hashes.
		Set<String> hashStrings = new HashSet<String>();
		hashStrings.add("a");
		hashStrings.add("b");
		hashStrings.add("c");
		hashStrings.add("a");
		hashStrings.add("b");
		hashStrings.add(new String("c"));
		System.out.println(hashStrings.size());
		System.out.println(hashStrings.remove("c"));	
		System.out.println(hashStrings.size());

		//Class StringBuffer does NOT override equals and hashCode out of the box!
		Set<StringBuffer> hashBuffers = new HashSet<StringBuffer>();
		hashBuffers.add(new StringBuffer("d"));
		hashBuffers.add(new StringBuffer("e"));
		hashBuffers.add(new StringBuffer("f"));
		hashBuffers.add(new StringBuffer("d"));
		hashBuffers.add(new StringBuffer("e"));
		hashBuffers.add(new StringBuffer("f"));
		//you successfully add the StringBuffer objects
		System.out.println(hashBuffers.size());
		//but when you try to get them back out, you fail!
		System.out.println(hashBuffers.remove(new StringBuffer("f")));	
		//all StringBuffers are still in the collection
		System.out.println(hashBuffers.size());

		//Class StringBuilder does NOT override equals and hashCode out of the box!
		Set<StringBuilder> hashBuilders = new HashSet<StringBuilder>();
		hashBuilders.add(new StringBuilder("d"));
		hashBuilders.add(new StringBuilder("e"));
		hashBuilders.add(new StringBuilder("f"));
		//you successfully add the StringBuffer objects
		System.out.println(hashBuilders.size());
		//but when you try to get them back out, you fail!
		System.out.println(hashBuilders.remove(new StringBuilder("f")));	
		//all StringBuffers are still in the collection
		System.out.println(hashBuilders.size());
	}
}