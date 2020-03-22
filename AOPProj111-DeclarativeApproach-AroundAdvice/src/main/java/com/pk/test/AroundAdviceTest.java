package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.BankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService proxy = null;
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("pfb", BankService.class);
		System.out.println(proxy.getClass()+"        "+proxy.getClass().getSuperclass());
		System.out.println("Simple Interset is :: "+proxy.calcSimpleInterestAmt(10000, 2, 3));
		System.out.println(".........................................................................................................................");  
		System.out.println("Simple Interset is :: "+proxy.calcSimpleInterestAmt(10000, 2, 3));
		System.out.println(".........................................................................................................................");
		System.out.println("Simple Interset is :: "+proxy.calcSimpleInterestAmt(20000, 2, 3));
		System.out.println(".........................................................................................................................");
		System.out.println("Simple Interset is :: "+proxy.calcSimpleInterestAmt(20000, 2, 3));
		System.out.println(".........................................................................................................................");  
		System.out.println("Compound Interset is :: "+proxy.calcCompoundInterestAmt(35000, 2, 3));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
