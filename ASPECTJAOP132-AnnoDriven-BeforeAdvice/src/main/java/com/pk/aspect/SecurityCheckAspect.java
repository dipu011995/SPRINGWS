package com.pk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pk.manager.AuthenticationManager;

@Component
@Aspect
public class SecurityCheckAspect  {

	@Autowired
	private AuthenticationManager manager;

		@Before("execution(String com.pk.service.BankServiceMgmt.*(..))")
		private void checkCredential(JoinPoint jp) throws Throwable{
			System.out.println("SecurityCheckAspect.securityCheck()");
			if(!manager.validate())
				throw  new IllegalArgumentException("Invalid Crediantial");
		}

}
