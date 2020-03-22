package com.pk.service;

import com.pk.dao.BankServiceDAO;

public class BankServiceMgmtImpl implements BankServiceMgmt {

	private BankServiceDAO bankServiceDao;
	
	public BankServiceMgmtImpl(BankServiceDAO bankServiceDao) {
		this.bankServiceDao = bankServiceDao;
	}

	public String deposite(int accNo, float amount) {
		int result = 0;
		//use DAO
		result = bankServiceDao.deposite(accNo, amount);
		if(result==0)
			return "Deposite Failed (Invalid Account no) accno = "+accNo;
		else
			return "Deposite  Sucessfuly of accno = "+accNo;
	}

	public String withdraw(int accNo, float amount) {
		int result = 0;
		//use DAO
		result = bankServiceDao.withdraw(accNo, amount);
		if(result==0)
			return "Withdraw Failed (Invalid Account no) accno = "+accNo;
		else
			return "Withdraw  Sucessfuly of accno = "+accNo;
	}

}
