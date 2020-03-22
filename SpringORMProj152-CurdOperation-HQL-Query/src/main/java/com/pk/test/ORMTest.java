package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pk.dto.EmployeeDTO;
import com.pk.service.EmployeeService;

public class ORMTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeService service = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("empService",EmployeeService.class);
		
		try {
			System.out.println("Employee details::"+service.fetchEmployeeByDesgUsingPparam("dev", "tester"));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		try {
			System.out.println("Employee details::"+service.fetchEmployeeByDesgUsingNparam("dev", "tester"));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		try {
			System.out.println("Employee details::"+service.fetchEmployeebySalRangeTakingGlobalNamedQuery(50000, 60000));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		try {
			System.out.println("Employee Removed::"+service.removeEmployeebySalarymark(60000));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		try {
			System.out.println("No Employees salary hiked  ::"+service.hikeEmpSalaryByDesg("admin", 0.1f));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		((AbstractApplicationContext) ctx).close();
	}

}
