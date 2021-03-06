package com.pk.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object ratVal = null;long start =0,end = 0;
	
		if(invocation.getMethod().getName().equalsIgnoreCase("add")||invocation.getMethod().getName().equalsIgnoreCase("sub")) {

			start = System.currentTimeMillis();
			ratVal = invocation.proceed();		
			end = System.currentTimeMillis();
			System.out.println(invocation.getClass().getMethods()+"  with argument  "+Arrays.toString(invocation.getArguments())+"Time taken to execute ::"+(end-start)+ "ms");
		}
		else {
			ratVal = invocation.proceed();
		}
			
		return ratVal;
	}

}
