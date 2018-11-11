package com.madhusudhan.wr.allaboutlambdas.advancedlambdas;

public class ReferenceUtil {

	public boolean isClassic(int movieId) {
		boolean isClassic = false;
		if (movieId < 1000) {
			isClassic = true;
		}
		return isClassic;
	}

	public static boolean isHorror(int movieId) {
		boolean isHorror = false;
		if (movieId > 10000 && movieId < 20000) {
			isHorror = true;
		}
		return isHorror;
	}

	public String isClassicName(String movieId) {
		String isClassic = "";
		
			isClassic = "Nitin";
		
		return isClassic;
	}

	public static String isHorrorName(String movieId) {
		String isHorror = null;
		
			isHorror = "Vandn";
		
		return isHorror;
	}
}
