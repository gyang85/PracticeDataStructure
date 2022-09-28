package com.java.design.pattern;

public class VirtualCardFactory extends VirtualCardAbstractFactory{

	@Override
	public VirtualCard getVirtualCard(String spName) {
		if (spName.equals("NTT")) {
			return new NTTVirtualCard();
		} else if (spName.equals("LVMR")){
			return new LVMRVirtaulCard();
		}
		return null;
	}

}
