package com.paniclater.enums;


class Day {
	// Instance Variables
	DayOfWeek day;

	// Constructors
	public Day(DayOfWeek day) {
		this.day = day;
	}// End of one-arg constructor.

	public Day(int dayNumber) {
		// Instantiate the variable, then change the value to specified value.
		this.day = DayOfWeek.SUNDAY;
		this.day.setDayNumber(dayNumber);
	}// End of one-arg constructor.

	// Getters and Setters
	public DayOfWeek getDay() {
		return this.day;
	}

	// Utility Methods
	public int compareTo(Day day) {
		// Returns 1 if it comes later in the week.
		if (this.day.getDayNumber() > day.getDay().getDayNumber()) {
			return 1;
			// Returns -1 if it comes earlier in the week.
		} else if (this.day.getDayNumber() < day.getDay().getDayNumber()) {
			return -1;
			// Returns 0 if they are the same day.
		} else {
			return 0;
		}
	}// End of compareTo method.

	public String nextDay() {
		return this.day.next().toString();
	}// End of nextDay method.

	public String toString() {
		return this.day.toString();
	}// End of toString method.
}// End of class.

public class DayTester {
    public static void main(String[] args) {
        Day sunday = new Day(DayOfWeek.SUNDAY);
        Day monday = new Day(DayOfWeek.MONDAY);
        Day tuesday = new Day(DayOfWeek.TUESDAY);
        Day wednesday = new Day(DayOfWeek.WEDNESDAY);
        Day thursday = new Day(DayOfWeek.THURSDAY);
        Day friday = new Day(DayOfWeek.FRIDAY);
        Day saturday = new Day(DayOfWeek.SATURDAY);

        Day day[] = new Day[7];
        day[0] = friday;
        //day[1] = friday;
        //day[2] = friday;
        day[1] = saturday;
        day[2] = monday;
        day[3] = sunday;
        day[4] = wednesday;
        //day[5] = friday;
        day[5] = tuesday;
        day[6] = thursday;

        printArr(day);
        printArrNextDay(day);
        selectionSortArr(day);
        printArr(day);
        printArrNextDay(day);

        Day dayOfWeek = new Day(5);
        System.out.println(dayOfWeek);
        System.out.println(dayOfWeek.toString());
        System.out.println(dayOfWeek.nextDay());
    }//End of main method.

    public static void printArr(Day[] arr) {
        System.out.print("[ ");
        for(int i = 0; i < arr.length; i++) {
            if(i == (arr.length - 1)) {
                System.out.println(arr[i].toString() + " ]");
            } else {
                System.out.print(arr[i].toString() + ", ");
            }
        }
    }//End of printArr method.

    public static void printArrNextDay(Day[] arr) {
        System.out.print("[ ");
        for(int i = 0; i < arr.length; i++) {
            if(i == (arr.length - 1)) {
                System.out.println(arr[i].nextDay() + " ]");
            } else {
                System.out.print(arr[i].nextDay() + ", ");
            }
        }
    }//End of printArrNextDay method.

    public static void selectionSortArr(Day[] arr) {
        int smallest = 0;
        for(int i = 0; i < arr.length; i++) {
            smallest = i;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j].compareTo(arr[smallest]) > 0) {
                    smallest = j;
                    Day temp = arr[i];
                    arr[i] = arr[smallest];
                    arr[smallest] = temp;
                }
            }
        }
    }//End of sortArr method.
}//End of class.