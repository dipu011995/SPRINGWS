package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.ShoppingService;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ShoppingService service = null;
		//create container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("pfb", ShoppingService.class);
		//invoke method
		try {
			System.out.println("Total Price is::"+service.getDetailsBillAmt(new String[]{"Shirt","Pant","shoes"}, new float[]{15000.0f,25000.0f,2000.0f}));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
