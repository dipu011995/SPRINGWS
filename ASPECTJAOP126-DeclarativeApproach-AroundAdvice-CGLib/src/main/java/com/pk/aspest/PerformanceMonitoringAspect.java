package com.pk.aspest;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAspect {

	public Object monitoring(ProceedingJoinPoint pjp) throws Throwable {
		long start = 0,end = 0;
		Object ratVal = null;
		start = System.currentTimeMillis();
		ratVal = pjp.proceed();
		end = System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" arguments "+Arrays.toString(pjp.getArgs())+" has taken time "+(end-start)+" ms to execute");
		
		return ratVal;
	}
}
