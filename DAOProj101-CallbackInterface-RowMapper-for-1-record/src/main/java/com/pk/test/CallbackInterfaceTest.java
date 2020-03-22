package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pk.dto.EmployeeDTO;
import com.pk.service.EmployeeService;

public class CallbackInterfaceTest {
	
	public static void main(String[] args) {
	
		ApplicationContext ctx = null;
		EmployeeDTO dto = null;
		EmployeeService service = null;
		
		//create ApplicationContext container
		ctx  = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", EmployeeService.class);
		try {
			//invoke method/use service
			dto= service.fetchEmpDetailsByNo(7844);
			System.out.println("7902 employee details::"+dto);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
	}//main()
}//class
