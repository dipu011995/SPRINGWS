package com.pk.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("performanceAdvice")
public class PerformanceMonitoringAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object ratVal = null;
		long start = System.currentTimeMillis();
		System.out.println("Before Entering into target class method Time is::"+start+"       class name"+invocation.getClass());
		ratVal = invocation.proceed();
		
		long end = System.currentTimeMillis();
		System.out.println("After executing target class method Time is::"+end );
		System.out.println("Time taken to execute ::"+(end-start)+ "ms");
		System.out.println(invocation.getClass().getMethods()+"  with argument  "+Arrays.toString(invocation.getArguments()));
		
		return ratVal;
	}

}
