package com.pk.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;

@Repository("empDAO2")
//@Primary
public class EmployeeDAOImpl2_LamdaImplementation_InnerClass implements EmployeeDAO {
	
	private static final String GET_EMP_DETAILS_BY_NO ="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO = ?";
	
	@Autowired
	private JdbcTemplate jt;

	public EmployeeBO getEMpDetailsByNo(int no) {
		System.out.println("EMployeeDAOImpl2.getEMpDetailsByNo()");
		EmployeeBO bo = null;
		bo = jt.queryForObject(GET_EMP_DETAILS_BY_NO,
														(rs,index)->{								
																			EmployeeBO bo1 = null;
																			//create obj
																			bo1 = new EmployeeBO();
																			bo1.setEmpno(rs.getInt(1));
																			bo1.setEname(rs.getString(2));
																			bo1.setJob(rs.getString(3));
																			bo1.setSal(rs.getFloat(4));
																			return bo1;
																	},
											 no);
		
		return bo;

	}//getEmpDetailsByNo()	

}//class
