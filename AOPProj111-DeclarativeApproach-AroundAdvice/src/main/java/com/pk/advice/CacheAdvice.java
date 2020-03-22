package com.pk.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor {

	Map<String, Object> cache = new HashMap<String, Object>();
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key = null;
		//get key
		key = invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		if(!cache.containsKey(key)) {
			cache.put(key,invocation.proceed());
			System.out.println("from target method");
		}
		System.out.println("From cache");
		return cache.get(key);
	}

}
