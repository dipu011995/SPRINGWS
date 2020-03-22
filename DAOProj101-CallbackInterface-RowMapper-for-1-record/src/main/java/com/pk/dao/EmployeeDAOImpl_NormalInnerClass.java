package com.pk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO")
//@Primary
public class EmployeeDAOImpl_NormalInnerClass implements EmployeeDAO {
	
	private static final String GET_EMP_DETAILS_BY_NO ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO = ?";
	
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEMpDetailsByNo(int no) {
		EmployeeBO bo = null;
		bo = jt.queryForObject(GET_EMP_DETAILS_BY_NO,new EmployeeMapper(), no);
		return bo;
	}
	
	private class EmployeeMapper implements RowMapper<EmployeeBO>{

		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("EMployeeDAOImpl.EmployeeMapper.mapRow()");
			EmployeeBO bo = null;
			//create obj
			bo = new EmployeeBO();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));
			return bo;
		}//row mapper()
	}//getEmpDetailsByNo()

	
}//class
