package com.java8.features;

public class FutureTest {

	public String get() {
		System.out.println("Get called");
		return "Fetched";
	}
	
	public String print(String receivedValue) {
		System.out.println("Print called "+receivedValue);
		return "Printed "+receivedValue;
	}
}
