package com.pk.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pk.config.AppConfig;
import com.pk.manager.AuthenticationManager;
import com.pk.service.BankServiceMgmt;
public class BeforeAdviceTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = null;
		AuthenticationManager authenticationManager = null;
		//BankServiceMgmt proxy = null;
		BankServiceMgmt proxy = null;
		
		//create Application context container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get bean 
		proxy = ctx.getBean("pfb", BankServiceMgmt.class);
		authenticationManager = ctx.getBean("authManager", AuthenticationManager.class);
		
		try {
			authenticationManager.login("raja", "rani");
			//b.method
			System.out.println(proxy.deposite(101, 1000));
			System.out.println(proxy.withdraw(101, 2000));
			
			authenticationManager.logout();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
