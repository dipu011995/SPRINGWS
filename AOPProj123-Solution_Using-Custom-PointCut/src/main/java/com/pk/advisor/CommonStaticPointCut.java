package com.pk.advisor;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.pk.service.CalculatorService;
import com.pk.service.CalculatorServiceimpl;

public class CommonStaticPointCut extends StaticMethodMatcherPointcut {

	String methodNames[] = null;
	
	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}

	public boolean matches(Method method, Class<?> targetClass) {
		String mName = null;
		if(targetClass==CalculatorServiceimpl.class) {
			mName = method.getName();
			
			if(methodNames.length!=0) {
				for(String mn:methodNames) {
					if(mn.equalsIgnoreCase(mName))
						return true;
				}
			}
			
		}
		return false;
	}

	

}
