package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.OnlineShopping;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		OnlineShopping service = null;
		//create IOC container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		//get Bean
		service = ctx.getBean("pfb", OnlineShopping.class);
		try {
			//invoke business method
			//System.out.println("Total Price is::"+service.calculateTotalBillAmt(new String[] {"Pant","Pant","shoes"}, new float[] {1500.0f,2000.0f,1800.0f}));
		//	System.out.println("Total Price is::"+service.calculateTotalBillAmt(null, new float[] {1500.0f,2000.0f,1800.0f}));
			System.out.println("Total Price is::"+service.calculateTotalBillAmt(null, null));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
