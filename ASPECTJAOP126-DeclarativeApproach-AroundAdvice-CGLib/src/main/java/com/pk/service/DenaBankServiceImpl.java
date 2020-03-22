package com.pk.service;

public class DenaBankServiceImpl  {

	public float calcSimpleInterestAmount(float pAmt, float rate, float time) {
		
		return (pAmt*rate*time)/100.0f;
	}

	public float calcCompoundInterestAmount(float pAmt, float rate, float time) {
		return (float) ((pAmt+Math.pow((1+rate/100.0f), time))-pAmt);
	}

	public float getBalance(float pAmt) {
		return pAmt;
	}

}
