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
		
		
		
		/*try {
		 	EmployeeDTO dto = null;
			dto = new EmployeeDTO();
		
			dto.setEname("sidhartha");
			dto.setDesg("admin");
			dto.setSalary(40000.0f);
			
			int result = service.addEmployee(dto);
			System.out.println("employee saved with employee no::"+result);
		}
		catch (DataAccessException dae) {
			System.out.println("employee not saved");
			dae.printStackTrace();
		}*/
		
		System.out.println("==============================================================================");
		
		try {
			System.out.println("Employee  id 1 Employee Details::"+service.fetchEmployeeById(1));
		}
		catch (DataAccessException dae) {
			System.out.println("No Employee Exits in this Id 1");
			dae.printStackTrace();
		}
		
System.out.println("==============================================================================");
		
		try {
			EmployeeDTO dto = null;
			dto = new EmployeeDTO();
			
			dto.setEid(5);
			dto.setEname("sid");
			dto.setDesg("admin");
			dto.setSalary(35000.0f);
			service.updateEmployee(dto);
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		((AbstractApplicationContext) ctx).close();
	}

}
