package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.DenaBankServiceImpl;

public class AspectjAOPAroundAdviceTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = null;
		DenaBankServiceImpl proxy = null;
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("bankService", DenaBankServiceImpl.class);
		System.out.println(proxy.getClass());
		//invoke methods
		System.out.println("Simple interest::"+proxy.calcSimpleInterestAmount(10000, 2, 12));
		System.out.println("...................................................");
		System.out.println("compound interest::"+proxy.calcCompoundInterestAmount(10000, 2, 12));
		System.out.println(".....................................................");
		System.out.println("Balance::"+proxy.getBalance(15000));
	}

}
