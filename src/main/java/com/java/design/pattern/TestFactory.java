package com.java.design.pattern;

public class TestFactory {

	public static void main(String[] args) {
		VirtualCardFactory virtualCardFactory = new VirtualCardFactory();
		VirtualCard virtualcard = virtualCardFactory.getVirtualCard("NTT");
		System.out.println(virtualcard.getPayload());
	}

}
