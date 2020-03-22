package com.pk.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import jdk.jfr.events.FileWriteEvent;

public class DiscountCoupenGenerationAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		float billAmt = 0.0f;
		String msg = null;
		Writer writer = null;
		//get billAmt;
		billAmt = (Float) returnValue;
		if(billAmt>=30000)
			msg = "Available 50% discount on next Purchase";
		else if(billAmt>=20000)
			msg = "Available 30% discount on next Purchase";
		else if(billAmt>=10000)
			msg = "Available 10% discount on next Purchase";
		else
			msg = "Available 5% discount on next Purchase";
		
		//add mag to writer
		writer = new FileWriter("E:/DiscountCoupen");
		writer.write(msg);
		writer.flush();
		writer.close();
	}

}
