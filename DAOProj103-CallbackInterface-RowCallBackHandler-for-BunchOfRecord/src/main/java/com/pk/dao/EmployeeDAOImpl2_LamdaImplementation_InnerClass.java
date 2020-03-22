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
	public List<EmployeeBO> getEmployeeByJob(String desg1, String desg2, String desg3) throws Exception {
		final List<EmployeeBO> listBO = new ArrayList<EmployeeBO>();
		jt.query(GET_EMPS_DETAILS_BY_DESG, 
								rs->{
									System.out.println("EmployeeDAOImpl2.getEmployeeByJob()::LAMBDA");
									EmployeeBO bo = new EmployeeBO();
									bo.setEmpno(rs.getInt(1));
									bo.setEname(rs.getString(2));
									bo.setJob(rs.getString(3));
									bo.setSal(rs.getFloat(4));
									listBO.add(bo);
								}, //lambda inner class
								desg1,desg2,desg3);
		return listBO;
	}
}//class
