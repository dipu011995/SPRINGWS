package com.pk.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.pk.service.CalculatorService;

@Configuration
@ComponentScan(basePackages = {"com.pk.service","com.pk.advice"})
public class AppConfig {
	
	@Autowired
	private CalculatorService target;
	
	@Bean("pfb")
	public ProxyFactoryBean getBean() {
		ProxyFactoryBean fBean = new ProxyFactoryBean();
		fBean.setTarget(target);
		fBean.setInterceptorNames("performanceAdvice");
		return fBean;
	}

}
