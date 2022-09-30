package com.threads;

public class ThreadTest {
	Object lock = new Object();
	
	public synchronized void fetch() throws InterruptedException {
		System.out.println("Fetch called = "+Thread.currentThread().getId());
		Thread.sleep(8000);
		System.out.println("Exit from fetch = "+Thread.currentThread().getId());
	}
	
	public synchronized void put() throws InterruptedException {
		System.out.println("put method called = "+Thread.currentThread().getId());
		Thread.sleep(5000);
		System.out.println("Exit from put = "+Thread.currentThread().getId());
	}
	
	public void putWithSynBlock() throws InterruptedException {
		//System.out.println("putWithSynBlock method called = "+Thread.currentThread().getId());
		synchronized (lock) {
			System.out.println("Aquired lock : putWithSynBlock method called = "+Thread.currentThread().getId());
			Thread.sleep(5000);
			System.out.println("Exit from putWithSynBlock = "+Thread.currentThread().getId());
		}
		
	}
}
