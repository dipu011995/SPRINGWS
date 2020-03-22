package com.pk.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
	
		Object ratVal = null;
		System.out.println("Entering into logging "+pjp.getSignature()+" with arguments"+Arrays.toString(pjp.getArgs()));
		
		if((Float)pjp.getArgs()[0]<50000)
			pjp.getArgs()[1] = ((Float)pjp.getArgs()[1])-0.5f;
		
		if((Float)pjp.getArgs()[0]<=0 || (Float)pjp.getArgs()[1]<=0 || (Float)pjp.getArgs()[2]<=0)
			throw new IllegalArgumentException("Invalid inputs");
		else
			ratVal = pjp.proceed();
		
		System.out.println("Exiting from logging "+pjp.getSignature()+" with arguments"+Arrays.toString(pjp.getArgs()));
		
		return ratVal;
		
	}
}
