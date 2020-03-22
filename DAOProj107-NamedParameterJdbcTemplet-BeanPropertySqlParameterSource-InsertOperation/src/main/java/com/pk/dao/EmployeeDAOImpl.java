package com.pk.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;


@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP (EMPNO,ENAME,JOB,SAL) VALUES (:empNO,:eName,:job,:sal) ";

	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		BeanPropertySqlParameterSource paramSource = null;
		//set value to BeanPropertySqlParameterSource
		paramSource = new BeanPropertySqlParameterSource(bo);
		return npjt.update(INSERT_EMPLOYEE, paramSource);
		
	}
	
	

}//class