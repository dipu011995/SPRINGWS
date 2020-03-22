package com.pk.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("cacheAspect")
@Aspect
@Order(1)
public class CacheingAspect {

	private Map<String, Object> map = new HashMap();
	
	@Around("execution(float com.pk.service.BankService.calc*(..))")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		String key = null;
		Object ratVal = null;
		//get key
		key = pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!map.containsKey(key)) {
			System.out.println("from target method");
			ratVal = pjp.proceed();
			map.put(key, ratVal);
			return map.get(key);
		}
		else {
			System.out.println("from map");
			return map.get(key);
		}
	}
}
