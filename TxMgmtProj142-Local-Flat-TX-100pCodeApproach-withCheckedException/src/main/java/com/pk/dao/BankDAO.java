package com.pk.dao;

public interface BankDAO {

	public int withdraw(int acno,float amt);
	public int deposite(int acno,float amt);
}
