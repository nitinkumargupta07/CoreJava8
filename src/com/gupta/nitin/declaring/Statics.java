package com.gupta.nitin.declaring;

public class Statics {
	static String who = "Member";
	public static void main(String[] args) {
		String who = "Local";
		System.out.println(who);
		System.out.println(new Statics().who);
		Statics statics=new Statics();
		statics=null;
		System.out.println(Statics.who);
	}
}