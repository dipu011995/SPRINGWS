package com.pk.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pk.manager.AuthenticationManager;

@Component("checkAdvice")
public class SecurityCheckAdvice implements MethodBeforeAdvice {
	
	@Autowired
	private AuthenticationManager manager;

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("SecurityCheckAdvice.before()");
		if(!manager.validate())
			throw  new IllegalArgumentException("Invalid Crediantial");
	}

}
