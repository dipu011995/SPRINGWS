package com.pk.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BankServiceDAOImpl implements BankServiceDAO {

	private static final String DEPOSITE_QUERY = "UPDATE BANK_SERVICE SET BALANCE=BALANCE+:amt WHERE ACCNO = :acno ";
	private static final String WITHDRAL_QUERY = "UPDATE BANK_SERVICE SET BALANCE=BALANCE-:amt WHERE ACCNO = :acno ";
	
	private NamedParameterJdbcTemplate npjc;
	
	public BankServiceDAOImpl(NamedParameterJdbcTemplate npjc) {
		this.npjc = npjc;
	}

	public int deposite(int accNo, float amount) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("acno", accNo);
		params.addValue("amt", amount);
		return npjc.update(DEPOSITE_QUERY, params);	
			
		/*	Map<String, Object> map = new HashMap();
			map.put("acno", accNo);
			map.put("amt", amount);
			return npjc.update(DEPOSITE_QUERY, map);*/
	}

	public int withdraw(int accNo, float amount) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("acno", accNo);
		params.addValue("amt", amount);
		return npjc.update(WITHDRAL_QUERY, params);		
		
		/*Map<String, Object> map = new HashMap();
		map.put("acno", accNo);
		map.put("amt", amount);
		return npjc.update(WITHDRAL_QUERY, map);*/
	}

}
