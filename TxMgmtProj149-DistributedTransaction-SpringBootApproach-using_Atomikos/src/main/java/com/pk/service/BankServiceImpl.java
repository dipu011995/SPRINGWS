package com.pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.DepositeDAO;
import com.pk.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private WithdrawDAO withdrawDAO;
	@Autowired
	private DepositeDAO depositeDAO;
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = IllegalAccessException.class,timeout = 10)
	public String teansferMoney(int sourceAcno, int destAcno, float amt) throws IllegalAccessException {
		int count1 = 0,count2 =0;
		
		count1 = withdrawDAO.withdrawMoney(sourceAcno, amt);
		
		/*	//to create the situation of timeout i.e if tx not completed in this time the tx will rollbacked
			try {
				Thread.sleep(20000);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}*/
		
		
		
		count2 = depositeDAO.depositeMoney(destAcno, amt);
		
		if(count1==0 || count2 ==0) {
			throw new IllegalAccessException("Transaction failed;Money not deducted from account");
		}
		else {
			return "Transaction scucessed; Money transfered sucessfully";
		}
	}

}
