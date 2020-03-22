package com.pk.service;

public class BankServiceImpl implements BankService {

	public float calcSimpleInterestAmt(float pAmt, float rate, float time) {
		System.out.println("BankServiceImpl.calcSimpleInterestAmt()");
		return (pAmt*rate*time)/100.0f;
	}

	public float calcCompoundInterestAmt(float pAmt, float rate, float time) {
		System.out.println("BankServiceImpl.calcCompoundInterestAmt()");
		return (float) ((pAmt*Math.pow(1+(rate/100), time))-pAmt);
	}

}
