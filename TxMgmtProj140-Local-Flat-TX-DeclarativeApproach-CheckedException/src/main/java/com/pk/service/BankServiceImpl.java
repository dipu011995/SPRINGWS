package com.pk.service;

import com.pk.dao.BankDAO;

public class BankServiceImpl implements BankService {

	private BankDAO dao;
	
	
	public BankServiceImpl(BankDAO dao) {
		System.out.println("BankServiceImpl.BankServiceImpl()");
		this.dao = dao;
	}

	public String transferMoney(int srcAcno, int destAcno, float amt) throws IllegalAccessException {
		int count1 = 0,count2 = 0;
		count1 = dao.withdraw(srcAcno, amt);
		count2 = dao.deposite(destAcno, amt);
		System.out.println("count1="+count1 +" "+"count2="+count2);
		
		if(count1==0 ||count2 ==0)
			throw new IllegalAccessException(" Transaction failed");
		else
			return "Transaction Sucessful";
	}

}
