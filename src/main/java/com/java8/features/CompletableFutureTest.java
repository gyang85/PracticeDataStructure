package com.java8.features;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

	public static void main(String args[]) {
		FutureTest futureTest = new FutureTest();
		CompletableFuture.supplyAsync(() -> futureTest.get()).thenApply((data) -> futureTest.print(data));
		System.out.println("Application exit");
	}

}
