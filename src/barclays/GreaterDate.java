package barclays;

import java.time.LocalDate;
import java.time.Month;

public class GreaterDate {
	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		System.out.println("Current Date=" + today);

		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date=" + firstDay_2014);
		
		int value=today.compareTo(firstDay_2014);
	System.out.println(value);
	
	System.out.println(today.isBefore( firstDay_2014 ));
	}

}
