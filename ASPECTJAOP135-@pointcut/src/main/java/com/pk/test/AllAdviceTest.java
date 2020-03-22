package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.pk.service.ArithmaticService;

public class AllAdviceTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = null;
		ArithmaticService proxy = null;
		
		ctx = new FileSystemXmlApplicationContext("src/main/java/com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("arService", ArithmaticService.class);
		
		//invoke method
		System.out.println("add::"+proxy.add(100, 200));
		System.out.println(".....................................................................................................");
		System.out.println("sub::"+proxy.sub(10, 20));
		System.out.println(".....................................................................................................");
		System.out.println("mul::"+proxy.sub(100, 200));
		System.out.println(".....................................................................................................");
		System.out.println("div::"+proxy.div(10, 0));
		System.out.println(".....................................................................................................");
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
