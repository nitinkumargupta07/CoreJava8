package lambdasinaction.chap10;

import java.util.*;

public class OptionalMain {

    public static String getCarInsuranceName(Optional<Person> person) {
    	
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }
    public static void main(String[] args) {
    	Optional<Person> person=Optional.empty();
    	getCarInsuranceName(person);
	}
}
