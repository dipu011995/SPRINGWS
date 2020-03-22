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
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO")
//@Primary
public class EmployeeDAOImpl_NormalInnerClass implements EmployeeDAO {
	
	private static final String GET_EMPS_DETAILS_BY_DESG ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getEmpsDetailsByDesg(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDAOImpl.getEmpsDetailsByDesg()");
		List<EmployeeBO> listBO = null;
		listBO = jt.query(GET_EMPS_DETAILS_BY_DESG, new EmployeeResultExtractor(), desg1,desg2,desg3);	
		return listBO;
	}
	
	public class EmployeeResultExtractor implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO = null;
			EmployeeBO empBO = null;
			listBO = new ArrayList<EmployeeBO>();
			while(rs.next()) {
				empBO = new EmployeeBO();
				empBO.setEmpno(rs.getInt(1));
				empBO.setEname(rs.getString(2));
				empBO.setJob(rs.getString(3));
				empBO.setSal(rs.getFloat(4));
				listBO.add(empBO);
			}
			return listBO;
		}//extractData(-)
	}//innerclass

}//class
