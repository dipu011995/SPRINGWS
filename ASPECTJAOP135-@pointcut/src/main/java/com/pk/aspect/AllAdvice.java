package com.pk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("allAdvice")
@Aspect
public class AllAdvice {
	
	@Pointcut("execution(float com.pk.service.ArithmaticService.*(..))")
	public void myPtc() {
		
	}

	@Around("myPtc()")
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
		Object ratVal = null;
		System.out.println("from monitor()");
		ratVal = pjp.proceed();
		return ratVal;
	}
	
	@Before("myPtc()")
	public void beforLogging(JoinPoint jp) {
		System.out.println("from beforLogging()");
	}
	
	@AfterReturning(value = "myPtc()", returning = "result")
	public void logAfter(JoinPoint jp,float result) {
		System.out.println("from logAfter()");
	}
	
	@AfterThrowing(value = "myPtc()",throwing = "ex")
	public void expLogger(JoinPoint jp,Exception ex) {
		System.out.println("from expLogger()");
	}
	
}
