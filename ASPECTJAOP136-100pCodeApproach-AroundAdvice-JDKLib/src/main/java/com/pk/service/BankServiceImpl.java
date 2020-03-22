package com.pk.service;

import org.springframework.stereotype.Service;

@Service("bankService")
public class BankServiceImpl implements BankService {

	public float calculateSimpleInterest(float pAmt, float rate, float time) {
		return (pAmt*rate*time)/100.0f;
	}

	public float calculateCompoundInterest(float pAmt, float rate, float time) {
		return (float) ((pAmt*Math.pow(1+(rate/100), time))-pAmt);
	}

}
