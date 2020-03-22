package com.pk.service;

public class ShoppingServiceImpl implements ShoppingService {

	public float getDetailsBillAmt(String items[],float prices[]) {
		float billAmt = 0.0f;
		for(Float price:prices) {
			billAmt = billAmt+price;
		}
		return billAmt;
	}

}
