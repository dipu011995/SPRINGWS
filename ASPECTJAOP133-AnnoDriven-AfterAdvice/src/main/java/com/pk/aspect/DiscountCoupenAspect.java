package com.pk.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("dsAspect")
@Aspect
public class DiscountCoupenAspect {

	@AfterReturning(value = "execution(float com.pk.service.OnlineShoopingService.*(..))",returning = "billAmt")
	public void generateCoupen(JoinPoint jp,float billAmt) throws IOException {
		String coupenMsg = null;
		Writer writer = null;
		
		if(billAmt>=50000)
			coupenMsg = "Available 40% discount on next purchase";
		else if(billAmt>=30000)
			coupenMsg = "Available 25% discount on next purchase";
		else if(billAmt>=10000)
			coupenMsg = "Available 15% discount on next purchase";
		else
			coupenMsg = "Available 5% discount on next purchase";
		
		
		System.out.println(coupenMsg);
		writer = new FileWriter("D:/DiscountCoupen.txt",true);
		writer.write("\n"+coupenMsg);
		writer.flush();
		writer.close();
	}
}
