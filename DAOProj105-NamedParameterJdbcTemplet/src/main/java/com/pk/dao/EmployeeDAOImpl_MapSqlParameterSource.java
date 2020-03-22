package com.pk.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO1")
//@Primary
public class EmployeeDAOImpl_MapSqlParameterSource implements EmployeeDAO {
	
     
	private static final String GET_EMP_NAME_BY_NO = "SELECT ENAME FROM EMP WHERE EMPNO = :id";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	public Map<String, Object> findEmployeeDetailsBYNo(int no) throws Exception {
		//     Unimplemented method
		return null;
	}


	public String findEmployeeNameByNo(int no) throws Exception {
		String name = null;
		MapSqlParameterSource sourceMap = null;
		
		sourceMap =  new MapSqlParameterSource();
		sourceMap.addValue("id", no);
		name = npjt.queryForObject(GET_EMP_NAME_BY_NO, sourceMap, String.class);
		return name;
	}


	
}
