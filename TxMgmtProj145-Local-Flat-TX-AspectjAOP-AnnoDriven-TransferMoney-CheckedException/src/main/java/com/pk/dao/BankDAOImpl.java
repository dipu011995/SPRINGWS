package com.pk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO {
	
	private final static String WITHDRAW_QUERY="UPDATE TX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO = ?";
	private final static String DEPOSITE_QUERY="UPDATE TX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO = ?";

	@Autowired
	private JdbcTemplate jt;
	

	public int withdraw(int acno, float amt) {	
		return jt.update(WITHDRAW_QUERY, amt,acno);
	}

	public int deposite(int acno, float amt) {
		return jt.update(DEPOSITE_QUERY, amt,acno);
	}

}
