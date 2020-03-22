package com.pk.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.advice.PerformanceMonitoringAdvice;
import com.pk.service.CalculatorService;
import com.pk.service.CalculatorServiceimpl;

public class programaticApproachTest {

	public static void main(String[] args) {
		CalculatorService target = null;
		PerformanceMonitoringAdvice advice = null;
		ProxyFactory factory = null;
		CalculatorService proxy = null;
		//target class obj
		target = new CalculatorServiceimpl();
		//create advice class obj
		advice = new PerformanceMonitoringAdvice();
		//create proxyFactory obj
		factory = new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		//get proxy obj
		proxy = (CalculatorService) factory.getProxy();
		//invoke method
		System.out.println("Add::"+proxy.addNumber(100, 200));
	}

}
