package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pk.service.EmployeeMgmtService;
import com.pk.service.EmployeeMgmtServiceImpl;

public class NamedParameterJdbcTempletTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", EmployeeMgmtServiceImpl.class);	
		try {
			System.out.println("7934 Employee Details:::"+ service.fetchEmployeeDetailsBYNo(7934));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("........................................................");
		try {
			System.out.println("7934 Employee name::"+service.fetchEmployeeDetailsByNo(7934));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
