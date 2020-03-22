package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.LoginMgmtService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		LoginMgmtService service = null;
		//create container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("reservationService", LoginMgmtService.class);
		
		//invoke method
		

	}

}
