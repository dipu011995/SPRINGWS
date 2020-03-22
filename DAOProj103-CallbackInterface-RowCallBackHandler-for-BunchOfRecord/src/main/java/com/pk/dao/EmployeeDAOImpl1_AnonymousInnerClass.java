package com.pk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO1")
@Primary
public class EmployeeDAOImpl1_AnonymousInnerClass implements EmployeeDAO {
	
	private static final String GET_EMPS_DETAILS_BY_DESG ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	
	@Override
	public List<EmployeeBO> getEmployeeByJob(String desg1, String desg2, String desg3) throws Exception {
		final List<EmployeeBO> listBO = new ArrayList<EmployeeBO>();

		jt.query(GET_EMPS_DETAILS_BY_DESG,
				new RowCallbackHandler() {				
					@Override
					public void processRow(ResultSet rs) throws SQLException {
					//	System.out.println("method::"+rs.getFetchSize());
						System.out.println(
								"EmployeeDAOImpl1.getEmployeeByJob(...).new RowCallbackHandler() {...}.processRow()");
						EmployeeBO bo = new EmployeeBO();
						bo.setEmpno(rs.getInt(1));
						bo.setEname(rs.getString(2));
						bo.setJob(rs.getString(3));
						bo.setSal(rs.getFloat(4));
						listBO.add(bo);				
					}//processRow method
				}, 	//anonomous innerClass		
				desg1,desg2,desg3);
		
		return listBO;
	}//getEmployeeByJob method
	
}//class
