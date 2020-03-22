package com.pk.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = null;
		Object ratVal = null;
		//modify argument value
		args = invocation.getArguments();
		if((Float)(args[0])<50000)
			args[1] = 3.0f;
		//controlling target method
		if( ((Float)args[0])==0.0f || ((Float)args[1])==0.0f || ((Float)args[2])==0.0f ) 
			return 0.0f;
		else 
			ratVal = invocation.proceed();
		if(((Float)ratVal)<=25000)
			return ratVal;
		else
			return ((Float)ratVal)+(((Float)ratVal)*0.1f);
	}

}
