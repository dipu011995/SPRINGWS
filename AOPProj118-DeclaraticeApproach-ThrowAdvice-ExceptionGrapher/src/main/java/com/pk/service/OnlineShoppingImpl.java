package com.pk.service;

public class OnlineShoppingImpl implements OnlineShopping {

	public float calculateTotalBillAmt(String[] items, float[] prices)  {
		System.out.println("OnlineShoppingImpl.calculateTotalBillAmt()");
		float billAmt = 0.0f;
			if(items==null || prices==null) {
				throw new IllegalArgumentException("Invalid inputs...");
			}
		for(float p:prices) {
			billAmt = billAmt+p;
		}
		return billAmt;
	}

}
