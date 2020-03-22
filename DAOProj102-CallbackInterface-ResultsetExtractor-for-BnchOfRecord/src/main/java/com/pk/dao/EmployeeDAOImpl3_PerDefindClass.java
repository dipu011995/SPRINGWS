package com.pk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO3")
@Primary
public class EmployeeDAOImpl3_PerDefindClass implements EmployeeDAO {
	
	private static final String GET_EMPS_DETAILS_BY_DESG ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getEmpsDetailsByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDAOImpl3_PerDefindClass.getEmpsDetailsByDesg()");
		BeanPropertyRowMapper<EmployeeBO> bprm = null;
		RowMapperResultSetExtractor rmre = null;
		List<EmployeeBO> listBO = null;
		
		bprm = new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class);
		rmre = new RowMapperResultSetExtractor(bprm);
		listBO = (List<EmployeeBO>) jt.query(GET_EMPS_DETAILS_BY_DESG, rmre, desg1,desg2,desg3);
		return listBO;
	}
	
}//class
