package com.pk.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAspect{

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
