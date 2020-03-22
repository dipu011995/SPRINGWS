package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.pk.config.AppConfig;
import com.pk.service.CalculatorService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringBootApproachTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CalculatorService proxy = null;
		ctx = SpringApplication.run(SpringBootApproachTest.class, args);
		proxy = ctx.getBean("pfb", CalculatorService.class);
		System.out.println(proxy.addNumber(150, 250));
	}

}
