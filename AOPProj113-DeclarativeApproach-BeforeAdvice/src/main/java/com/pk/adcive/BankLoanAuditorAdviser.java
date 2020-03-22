package com.pk.adcive;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

import com.pk.dto.CustomerLoanDetails;

public class BankLoanAuditorAdviser implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		String auditmsg = null;
		Writer writer = null;
		
		System.out.println(method.getName()+"     "+Arrays.toString(args)+"     "+target.getClass().getName());
		if(method.getName().equalsIgnoreCase("generateLoanId")) {
			auditmsg = ((CustomerLoanDetails)args[0]).getCustomerName()+" customer  came for loan verification to "+((CustomerLoanDetails)args[0]).getClerkName()+" on  "+new Date();
		}
		else if(method.getName().equalsIgnoreCase("approveLoan")) {
			auditmsg = ((CustomerLoanDetails)args[1]).getCustomerName()+" customer with cust id "+  ((Integer)args[0])+" came for loan verification to "+((CustomerLoanDetails)args[1]).getManagerName()+" on  "+new Date();
		}
		else {
			throw new IllegalArgumentException("Invalid method");
		}
		
		writer = new FileWriter("D:/aopBeforeAdvice.txt",true);
		writer.write("\n " + auditmsg);
		writer.flush();
		writer.close();
	}

}
