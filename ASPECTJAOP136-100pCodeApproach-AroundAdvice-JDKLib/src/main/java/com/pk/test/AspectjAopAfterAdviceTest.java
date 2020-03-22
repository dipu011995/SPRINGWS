package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.config.Appconfig;
import com.pk.service.BankService;

public class AspectjAopAfterAdviceTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = null;
		BankService proxy = null;
		
		ctx = new AnnotationConfigApplicationContext(Appconfig.class);
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
