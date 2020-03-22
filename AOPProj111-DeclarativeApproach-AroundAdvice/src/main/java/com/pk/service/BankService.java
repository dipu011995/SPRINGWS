package com.pk.service;

public interface BankService {

	public float calcSimpleInterestAmt(float pAmt,float rate,float time);
	public float calcCompoundInterestAmt(float pAmt,float rate,float time);
}
