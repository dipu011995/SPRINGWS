package com.pk.dao;

public interface BankServiceDAO {

	public int deposite(int accNo,float amount);
	public int withdraw(int accNo,float amount);
}
