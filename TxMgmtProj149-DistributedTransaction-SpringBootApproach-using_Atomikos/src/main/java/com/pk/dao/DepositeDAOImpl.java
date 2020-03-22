package com.pk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("mysqlDAO")
public class DepositeDAOImpl implements DepositeDAO {

	private static final String DEPOSITE_QUERY = "UPDATE MYSQL_DTS_ACCOUNT SET BALANCE = BALANCE + ? WHERE ACCNO = ? ";
	
	@Autowired
	@Qualifier(value = "mysqlTemplet")
	private JdbcTemplate jt;
	
	public int depositeMoney(int acno, float amt) {
		return jt.update(DEPOSITE_QUERY, amt,acno);
	}

}
