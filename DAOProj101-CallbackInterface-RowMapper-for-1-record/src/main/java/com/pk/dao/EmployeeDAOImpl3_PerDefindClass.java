package com.pk.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO3")
@Primary
public class EmployeeDAOImpl3_PerDefindClass implements EmployeeDAO {
	
	private static final String GET_EMP_DETAILS_BY_NO ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO = ?";
	
	
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEMpDetailsByNo(int no) {
		System.out.println("EMployeeDAOImpl3.getEMpDetailsByNo()");
		EmployeeBO bo = null;
		bo = jt.queryForObject(GET_EMP_DETAILS_BY_NO,
														new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class),
											 		no);
		
		return bo;

	}//getEmpDetailsByNo()	

}//class
