package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.OnlineShoopingService;

public class AspectjAopAfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		OnlineShoopingService proxy = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("osService", OnlineShoopingService.class);
		//invoke method
		try {
			System.out.println("Result::"+proxy.calcBillAmt(new String[] {"shirt", "pant","shoe"}, new float[] {20000.0f,30000.0f,4000.0f}));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
