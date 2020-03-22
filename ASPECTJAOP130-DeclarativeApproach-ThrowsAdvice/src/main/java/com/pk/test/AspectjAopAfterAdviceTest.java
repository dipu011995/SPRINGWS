package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.ArithmaticService;


public class AspectjAopAfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ArithmaticService proxy = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("arithmaticService", ArithmaticService.class);
		//invoke method
		try {
			System.out.println("Result::"+proxy.div(10, 0));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
