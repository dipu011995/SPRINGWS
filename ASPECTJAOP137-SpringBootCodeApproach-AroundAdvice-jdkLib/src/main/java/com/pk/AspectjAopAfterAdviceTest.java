package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pk.service.BankService;

@SpringBootApplication
public class AspectjAopAfterAdviceTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = null;
		BankService proxy = null;
		
		ctx = SpringApplication.run(AspectjAopAfterAdviceTest.class, args);
		proxy = ctx.getBean("bankService", BankService.class);
		
		//invoke method
		System.out.println("simple Interest amt::"+proxy.calculateSimpleInterest(40000, 2, 12));
		System.out.println(".....................................................................................................");
		System.out.println("simple Interest amt::"+proxy.calculateSimpleInterest(40000, 2, 12));
		System.out.println(".....................................................................................................");
		System.out.println("Compound Interest Amt::"+proxy.calculateCompoundInterest(40000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
