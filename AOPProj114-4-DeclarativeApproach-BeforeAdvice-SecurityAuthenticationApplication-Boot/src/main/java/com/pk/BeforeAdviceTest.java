package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.pk.config.AppConfig;
import com.pk.manager.AuthenticationManager;
import com.pk.service.BankServiceMgmt;
@SpringBootApplication
@Import(AppConfig.class)
public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		AuthenticationManager authenticationManager = null;
		BankServiceMgmt proxy = null;
		
		ctx = SpringApplication.run(BeforeAdviceTest.class, args);
		
		//create Application context container
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get bean 
		authenticationManager = ctx.getBean("authManager", AuthenticationManager.class);
		proxy = ctx.getBean("pfb", BankServiceMgmt.class);
		
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
