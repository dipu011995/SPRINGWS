package com.pk.test;

import java.util.ArrayList;
import java.util.List;

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
		List<EmployeeDTO> listDTO = null;
		
		//create ApplicationContext container
		ctx  = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", EmployeeService.class);
		
		try {
			listDTO = new ArrayList<EmployeeDTO>();
			//invoke method
			listDTO =  service.fetchEmpsDetailsByDesg("CLERK", "SALESMAN", "MANAGER");
			System.out.println(listDTO);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main()
}//class
