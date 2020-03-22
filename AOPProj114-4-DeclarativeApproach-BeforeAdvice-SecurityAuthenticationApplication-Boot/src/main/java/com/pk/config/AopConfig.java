package com.pk.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pk.advice.SecurityCheckAdvice;
import com.pk.service.BankServiceMgmt;

@Configuration
public class AopConfig {

	@Autowired
	private BankServiceMgmt target;
	
	@Bean("pfb")
	public ProxyFactoryBean getProxyFactoryBean() {
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(target);
		pfb.setInterceptorNames("checkAdvice");
		return pfb;
	}
}
