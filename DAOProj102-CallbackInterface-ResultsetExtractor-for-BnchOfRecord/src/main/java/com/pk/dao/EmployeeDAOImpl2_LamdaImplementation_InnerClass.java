package com.pk.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO2")
//@Primary
public class EmployeeDAOImpl2_LamdaImplementation_InnerClass implements EmployeeDAO {
	
	private static final String GET_EMPS_DETAILS_BY_DESG ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getEmpsDetailsByDesg(String desg1, String desg2, String desg3) throws Exception {
		
		List<EmployeeBO> listBO = null;
		//get ResultSet records
		listBO = jt.query(GET_EMPS_DETAILS_BY_DESG, 
				
											rs->{
												System.out.println(
														"EmployeeDAOImpl2_LamdaImplementation_InnerClass.getEmpsDetailsByDesg()");
												List<EmployeeBO> listBO1 = null;
												EmployeeBO empBO = null;
												listBO1 = new ArrayList<EmployeeBO>();
												while(rs.next()) {
													empBO = new EmployeeBO();
													empBO.setEmpno(rs.getInt(1));
													empBO.setEname(rs.getString(2));
													empBO.setJob(rs.getString(3));
													empBO.setSal(rs.getFloat(4));
													listBO1.add(empBO);
												}//while												
												return listBO1;
											},
									desg1, desg2,desg3);
		
		return listBO;
	}

	
}//class
