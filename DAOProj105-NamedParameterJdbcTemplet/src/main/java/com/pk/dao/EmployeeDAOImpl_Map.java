package com.pk.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
@Primary
public class EmployeeDAOImpl_Map implements EmployeeDAO {
	
	private static final String GET_EMP_DETAILS_BY_NO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO = :id";     
	
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	public Map<String, Object> findEmployeeDetailsBYNo(int no) throws Exception {
		Map<String, Object> empMap = null;
		Map<String, Object> paramMap = null;
		
		paramMap = new HashMap();
		paramMap.put("id", no);
		
		empMap = npjt.queryForMap(GET_EMP_DETAILS_BY_NO, paramMap);
		
		return empMap;
	}

	public String findEmployeeNameByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
