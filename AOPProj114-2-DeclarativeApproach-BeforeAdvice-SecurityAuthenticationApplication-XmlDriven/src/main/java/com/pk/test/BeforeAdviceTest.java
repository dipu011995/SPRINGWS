package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.manager.AuthenticationManager;
import com.pk.service.BankServiceMgmt;

public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		AuthenticationManager authenticationManager = null;
		BankServiceMgmt proxy = null;
		
		//create Application context container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		//get bean 
		authenticationManager = ctx.getBean("authManager", AuthenticationManager.class);
		proxy = ctx.getBean("pfb", BankServiceMgmt.class);
		
		try {
			authenticationManager.login("raja", "rani");
			//b.method
			System.out.println("1"+proxy.deposite(101, 1000));
			System.out.println(proxy.withdraw(101, 2000));
			
			authenticationManager.logout();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
