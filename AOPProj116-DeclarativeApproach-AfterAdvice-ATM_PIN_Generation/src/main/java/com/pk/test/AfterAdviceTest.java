package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.AtmPinGenerationService;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		AtmPinGenerationService service = null;
		//create IOC container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		//get Bean
		service = ctx.getBean("pfb", AtmPinGenerationService.class);
		try {
			//invoke business method
			System.out.println(service.generateATMPin());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
