package com.pk.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.model.LoginDetails;

@Repository("authDAO")
public class AuthenticationDAOImpl implements AuthenticationDAO {
	private static final String AUTH_QUERY = "SELECT COUNT(*) FROM USER_AUTHENTICATION WHERE USERNAME =:user AND PASSWORD =:pwd";
	
	@Autowired
	private NamedParameterJdbcTemplate npjc;

	public int authenticate(LoginDetails details) {
		Map<String, String> map = new HashMap();
		map.put("user",  details.getUserName());
		map.put("pwd", details.getPassword());
		return npjc.queryForObject(AUTH_QUERY,map,Integer.class);
	}

}
