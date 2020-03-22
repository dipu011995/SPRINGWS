package com.pk.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO {
	
	private final static String WITHDRAW_QUERY="UPDATE TX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO = ?";
	private final static String DEPOSITE_QUERY="UPDATE TX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO = ?";

	private JdbcTemplate jt;
	
	public BankDAOImpl(JdbcTemplate jt) {
		System.out.println("BankDAOImpl.BankDAOImpl()");
		this.jt = jt;
	}

	public int withdraw(int acno, float amt) {	
		return jt.update(WITHDRAW_QUERY, amt,acno);
	}

	public int deposite(int acno, float amt) {
		return jt.update(DEPOSITE_QUERY, amt,acno);
	}

}
