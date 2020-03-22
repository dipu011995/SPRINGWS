package com.pk.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AtmPinGenerationAdvice  implements AfterReturningAdvice{

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AtmPinGenerationAdvice.afterReturning():::atm generated pin:: "+returnValue);
		if(((Integer)returnValue) <= 999)
			throw new IllegalAccessException("Weak pin generated:: Plz try again");		
	}

	
}
