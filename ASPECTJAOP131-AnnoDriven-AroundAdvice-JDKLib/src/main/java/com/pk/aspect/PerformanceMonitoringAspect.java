package com.pk.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAspect")
@Aspect
@Order(2)
public class PerformanceMonitoringAspect{

	@Around("execution(float com.pk.service.BankService.calc*(..))")
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
		long start,end = 0;
		Object ratVal = null;
		start = System.currentTimeMillis();
		ratVal = pjp.proceed();
		end = System.currentTimeMillis();
		System.out.println("Before Entering into target class method Time is::"+start+"       class name"+pjp.getClass());
		
		return ratVal;
	}

	
}
