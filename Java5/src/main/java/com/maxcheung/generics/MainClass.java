package com.maxcheung.generics;

public class MainClass {
	public static void main(String args[]) {
		// Create a Gen reference for Integers.
		GenericClass<Integer> iOb = new GenericClass<Integer>(88);
		iOb.showType();

		// no cast is needed.
		int v = iOb.getob();
		System.out.println("value: " + v);

		// Create a Gen object for Strings.
		GenericClass<String> strOb = new GenericClass<String>("Generics Test");
		strOb.showType();

		String str = strOb.getob();
		System.out.println("value: " + str);
	}
}