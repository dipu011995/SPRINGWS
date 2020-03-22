package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.BankService;

public class DistributedTransactionTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService proxy = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("bankService", BankService.class);
		//invoke method
		try {
			System.out.println(proxy.teansferMoney(1001, 1002, 5000));
		}
		catch ( IllegalAccessException e) {
			e.printStackTrace();
		}

		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
