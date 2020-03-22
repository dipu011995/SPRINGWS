package com.pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pk.dao.BankServiceDAO;

@Service("bankService")
public class BankServiceMgmtImpl implements BankServiceMgmt {

	@Autowired
	@Qualifier(value = "bankDAO")
	private BankServiceDAO bankServiceDao;

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
