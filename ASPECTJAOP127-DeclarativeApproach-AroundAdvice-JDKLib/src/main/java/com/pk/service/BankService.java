package com.pk.service;

public interface BankService {

	public float calculateSimpleInterest(float pAmt,float rate,float time);
	public float calculateCompoundInterest(float pAmt,float rate,float time);
}
