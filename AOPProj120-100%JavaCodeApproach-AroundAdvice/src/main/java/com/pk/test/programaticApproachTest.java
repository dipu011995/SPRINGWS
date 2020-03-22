package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.pk.config.AppConfig;
import com.pk.service.CalculatorService;

@Configuration
public class programaticApproachTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CalculatorService proxy = null;
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		proxy = ctx.getBean("pfb", CalculatorService.class);
		System.out.println(proxy.addNumber(150, 250));
	}

}
