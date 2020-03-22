package com.pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDAO dao;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = IllegalAccessException.class)
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
