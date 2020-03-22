package com.pk.service;

import org.springframework.stereotype.Service;

@Service("osService")
public class OnlineShoppingServiceImpl implements OnlineShoopingService {

	public float calcBillAmt(String items[], float prices[]) {
		float billAmt = 0;
		for(Float p:prices) {
			billAmt = billAmt+p;
		}
		return billAmt;
	}
}
