package com.pk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.bo.UserBO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	private static final String AUTH_QUERY = "SELECT COUNT(*) FROM USER_AUTH WHERE USERNAME = :user AND PASSWORD = :pwd";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int validate(UserBO bo) {
		
		return jt.queryForObject(AUTH_QUERY, Integer.class, bo.getUser(),bo.getPwd());
	}

}
