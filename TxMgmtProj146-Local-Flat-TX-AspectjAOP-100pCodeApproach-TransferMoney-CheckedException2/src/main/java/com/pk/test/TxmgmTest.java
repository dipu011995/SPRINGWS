package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pk.config.AppConfig;
import com.pk.service.BankService;

public class TxmgmTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService service = null;
		
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		service = ctx.getBean("bankService", BankService.class);
		//invoke method
		try {
			System.out.println(service.transferMoney(1001, 1006, 2000));
		}
		catch (IllegalAccessException iae) {
			iae.printStackTrace();
		}
	}

}
