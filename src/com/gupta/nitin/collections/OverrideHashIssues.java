package com.gupta.nitin.collections;

import java.util.*;
import java.lang.Integer;;

public class OverrideHashIssues {
	public static void main(String[] args) {
		//create a HashSet object of generic type Lost called lost stuff.
		Set<Lost> lostStuff = new HashSet<Lost>();
		for(int i = 0; i < 5; i++) {
			//make some Lost objects and stuff them in.
			Lost lost = new Lost(i);
			lostStuff.add(lost);
			System.out.println(lostStuff.contains(lost) + " " + lost.toString());
		}	
		System.out.println(lostStuff.size());
		for(int i = 0; i < 5; i++) {
			//create lost objects seemingly identical to objects inside of lostStuff
			Lost lost = new Lost(i);
			//check if there are matching objects in lostStuff
			System.out.println(lostStuff.contains(lost) + " " + lost.toString());
			//try to remove them from lostStuff
			lostStuff.remove(new Lost(i));

		}
		System.out.println("Actual contents of lostStuff");
		for(Lost lostGuy : lostStuff) System.out.println(lostGuy.toString());
		System.out.println("You can't remove what you can't find.");
		System.out.println(lostStuff.size());
		
		// You can't even add these guys to a tree unless you implement comparable or override compareTo!

		// TreeSet<Lost> lostTree = new TreeSet<Lost>();
		// for(int i = 0; i < 5; i++) {
		// 	//make some Lost objects and stuff them in.
		// 	Lost lost = new Lost(i);
		// 	lostTree.add(lost);
		// 	System.out.println(lostTree.contains(lost) + " " + lost.toString());
		// }

		// for(Lost lostGuy : lostTree) System.out.println(lostGuy.toString());

		//Because Found properly overrides equals() and hashCode() you can find and remove elements from the HashSet
		Set<Found> foundStuff = new HashSet<Found>();
		for(int i = 0; i < 5; i++) {
			//make some Found objects and stuff them in.
			Found found = new Found(i);
			foundStuff.add(found);
			System.out.println(lostStuff.contains(found) + " " + found.toString());
		}	
		System.out.println(foundStuff.size());
		for(int i = 0; i < 5; i++) {
			//create found objects identical to objects inside of foundStuff
			Found found = new Found(i);
			//check if there are matching objects in foundStuff
			System.out.println(foundStuff.contains(found) + " " + found.toString());
			//try to remove them from foundStuff
			foundStuff.remove(new Found(i));

		}
		System.out.println("Actual contents of lostStuff");
		for(Found foundGuy : foundStuff) System.out.println(foundGuy.toString());
		System.out.println("You can remove what you can't find.");
		System.out.println(foundStuff.size());
	}	
}

class Lost {
	//class Lost does not override equals() or hashCode(), so once its elements are added to a HashSet
	//You can never find them again!
	int a;
	Lost(int a) { this.a = a; }
	public int getA() { return a; }
	public void setA(int a) { this.a = a; }
	public String toString() {
		return "I'm lost " + a;
	}
}

class Found {
	//class Found will properly implement equals and hashCode so we can see the difference.
	int a;
	Found(int a) { this.a = a; }
	public int getA() { return a; }
	public void setA(int a) { this.a = a; }
	public String toString() {
		return "I'm lost " + a;
	}
	public boolean equals(Object o) {
		return(this.a == ((Found)o).getA());
	}
	public int hashCode() {
		return(this.a);
	}
}