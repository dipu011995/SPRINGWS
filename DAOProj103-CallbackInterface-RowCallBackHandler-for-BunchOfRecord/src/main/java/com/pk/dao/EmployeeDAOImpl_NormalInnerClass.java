package com.pk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO")
//@Primary
public class EmployeeDAOImpl_NormalInnerClass implements EmployeeDAO {
	
	private static final String GET_EMPS_DETAILS_BY_DESG ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getEmployeeByJob(String desg1, String desg2, String desg3) throws Exception {
		
		//               Not possible bcz innerf class return type is void
	
		return null;
	}

	
	
	
	/*@Override
	public List<EmployeeBO> getEmployeeByJob(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeBO> listBO = null;
		listBO = jt.query(GET_EMPS_DETAILS_BY_DESG, new EmployeeRowCallBackHandler(), desg1,desg2,desg3);
		return listBO;
	}
	
	public class EmployeeRowCallBackHandler implements RowCallbackHandler{
	
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			List<EmployeeBO> listBO = null;
			EmployeeBO empBO = null;
			listBO = new ArrayList();
			while(rs.next()) {
				empBO = new EmployeeBO();
				empBO.setEmpno(rs.getInt(1));
				empBO.setEname(rs.getString(2));
				empBO.setJob(rs.getString(3));
				empBO.setSal(rs.getFloat(4));
				listBO.add(empBO);	
			}//while			
		}//inner class
	}*/

}//class
