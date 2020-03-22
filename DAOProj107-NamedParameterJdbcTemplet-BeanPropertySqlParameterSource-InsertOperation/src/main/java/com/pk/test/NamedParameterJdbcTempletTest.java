package com.pk.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pk.dto.EmployeeDTO;
import com.pk.service.EmployeeMgmtService;
import com.pk.service.EmployeeMgmtServiceImpl;

public class NamedParameterJdbcTempletTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;
		Scanner sc = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", EmployeeMgmtServiceImpl.class);	
		sc = new Scanner(System.in);
		EmployeeDTO dto = null;
		try {
			dto = new EmployeeDTO();
			System.out.println("Enter Employee No::");
			dto.setEmpNO(sc.nextInt());
			System.out.println("Enter Employee Name::");
			dto.setEName(sc.next());
			System.out.println("Enter Employee Designation::");
			dto.setJob(sc.next());
			System.out.println("Enter Employee Salary::");
			dto.setSal(sc.nextInt());
			System.out.println(" Employee Details by Desg:::"+ service.registerEmployee(dto));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
