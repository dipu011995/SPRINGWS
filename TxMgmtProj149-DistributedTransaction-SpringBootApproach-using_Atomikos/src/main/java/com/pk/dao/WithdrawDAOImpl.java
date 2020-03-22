package com.pk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("oraDAO")
public class WithdrawDAOImpl implements WithdrawDAO {

	private static final String WITHDRAW_QUERY = "UPDATE ORA_DTS_ACCOUNT SET BALANCE = BALANCE - ? WHERE ACCNO = ? ";
	
	@Autowired
	@Qualifier(value = "oraTemplet")
	private JdbcTemplate jt;
	
	public int withdrawMoney(int acno, float amt) {
		return jt.update(WITHDRAW_QUERY, amt,acno);
	}

}
