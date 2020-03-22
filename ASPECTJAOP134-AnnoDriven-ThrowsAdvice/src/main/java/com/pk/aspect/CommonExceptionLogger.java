package com.pk.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Component("loggerAspect")
public class CommonExceptionLogger {

	@AfterThrowing(value = "execution(float com.pk.service.ArithmaticService.*(..))",throwing = "ex")
	 public   void exceptionLogger(JoinPoint jp,ArithmeticException ex) {
		 System.out.println(ex.toString()+" exception is raised in"+jp.getSignature()+" with args"+Arrays.deepToString(jp.getArgs()));
	 }
	 
	/* public   void exceptionLogger(JoinPoint jp,Exception e) {
		 System.out.println(e.toString()+" exception is raised in"+jp.getSignature()+" with args"+Arrays.deepToString(jp.getArgs()));
	 }*/

}
