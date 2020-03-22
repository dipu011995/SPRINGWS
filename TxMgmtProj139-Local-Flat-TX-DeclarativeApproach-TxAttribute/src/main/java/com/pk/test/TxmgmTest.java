package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.BankService;

public class TxmgmTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService service = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("tpfb", BankService.class);
		//invoke method
		try {
			System.out.println(service.transferMoney(1001, 1006, 2000));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
