package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pk.service.BankMgmtService;

public class MappingSQLOperationsAsSubClassTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankMgmtService service = null;
		//create container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("custService", BankMgmtService.class);
		
		//invoke method
		try {
			System.out.println(service.fetchEmpDetailsById(101));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		try {
			System.out.println(service.fetchCustomersDetailsByBalanceRange(10000.0f, 100000.0f));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		

	}

}
