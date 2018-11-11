package com.paniclater.generics;
import java.util.*;
public class ClassGeneric {
	public static void main(String[] args) { 
		List<Bonobo> bonoboList = new ArrayList<Bonobo>();
		bonoboList.add(new Bonobo());
		bonoboList.add(new Bonobo());
		bonoboList.add(new Bonobo());
		OneMonkeyList<Bonobo> oneMonkeyList = new OneMonkeyList<Bonobo>(bonoboList);
		oneMonkeyList.addMonkey(new Bonobo());
		//if you try to add anything besides a Bonobo to monkeyList it will throw a compiler cannot find symbol error, even if the 
		//class you are adding is a subclass of Monkey or Bonobo!
		//oneMonkeyList.add(new Chimpanzee());

		//now if we try to do the same thing with ManyMonkeyList we can add any type of Monkey or subtype but nothing else!
		List<Bonobo> monkeyList = new ArrayList<Bonobo>();
		monkeyList.add(new Bonobo());
		monkeyList.add(new Bonobo());
		monkeyList.add(new Bonobo());
		ManyMonkeyList<Bonobo> manyMonkeyList = new ManyMonkeyList<Bonobo>(monkeyList);

		List<Chimpanzee> chimpList = new ArrayList<Chimpanzee>();
		chimpList.add(new Chimpanzee());
		chimpList.add(new Chimpanzee());
		chimpList.add(new Chimpanzee());
		
		ManyMonkeyList<Chimpanzee> manyChimpList = new ManyMonkeyList<Chimpanzee>(chimpList);
		//The following fails because Object is not a subtype of monkey!
		//List<Object> objectList = new ArrayList<Object>();
		//ManyMonkeyList<Object> objectMonkeyList = new ManyMonkeyList<Object>(objectList);
		
	}
}
//the syntax in the class direction lets Type T to refer to Monkey or any subclass of Monkey
class ManyMonkeyList<T extends Monkey> {
	List<T> list;
	public ManyMonkeyList(List<T> list) {
		this.list = list;
	}
	public void addMonkey(T t) {
		list.add(t);
	}
}
class OneMonkeyList<T> {
	List<T> list;
	public OneMonkeyList(List<T> list) {
		this.list = list;
	}
	public void addMonkey(T t) {
		list.add(t);
	}
}
abstract class Monkey {

}
class Chimpanzee extends Monkey {

}
class Bonobo extends Monkey {

}