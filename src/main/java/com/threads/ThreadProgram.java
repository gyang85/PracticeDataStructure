package com.threads;

public class ThreadProgram {

	public static void main(String args[]) {
		ThreadTest test = new ThreadTest();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					test.fetch();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					test.put();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					test.putWithSynBlock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					test.putWithSynBlock();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		//t2.start();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Application exit");
		//t3.start();
		//t4.start();
	}
}
