package com.pk.service;

import java.util.Random;

public class OnlineShoppingImpl implements OnlineShopping {

	public float calculateTotalBillAmt(String[] items, float[] prices) {
		System.out.println("OnlineShoppingImpl.calculateTotalBillAmt()");
		float billAmt = 0.0f;
		try {
		if(items==null || prices==null)
			throw new NullPointerException("Null VAlue Found");
		}
		catch(NullPointerException npe) {
			throw new NullPointerException("Null VAlue Found");
		}
		
		return new Random().nextFloat();
	}
	
	@Override
	public String toString() {
		
		return "ToString";
	}
	
}
