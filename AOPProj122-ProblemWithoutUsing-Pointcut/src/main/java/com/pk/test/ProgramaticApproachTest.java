package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.advice.PerformanceMonitoringAdvice;
import com.pk.service.CalculatorService;
import com.pk.service.CalculatorServiceimpl;

public class ProgramaticApproachTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CalculatorService service = null;
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		//get service obj
		service = ctx.getBean("pfb", CalculatorService.class);
		//invoke method
		System.out.println("Add::"+service.add(100, 200));
		System.out.println(".....................................................................................");
		
		System.out.println("Add::"+service.sub(100, 200));
		System.out.println(".....................................................................................");
		
		System.out.println("Add::"+service.mul(100, 200));
		System.out.println(".....................................................................................");
		
		System.out.println("Add::"+service.div(100, 200));
		System.out.println(".....................................................................................");
	
		((AbstractApplicationContext) ctx).close();
	}

}
