package com.pk.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionLoggerThrowAdvice implements ThrowsAdvice {
	
	/*public void afterThrowing(IllegalArgumentException iae) throws IOException {
		Writer writer = new FileWriter("E:/LoggerException.txt");
		writer.write("Invalid values");
		writer.flush();
		writer.close();
	}*/
	
	public void afterThrowing(Object retVal,Object args[],Object target,NullPointerException iae) throws IOException {
		System.out.println("ExceptionLoggerThrowAdvice.afterThrowing()");
		String msg = null;
		Writer writer = null;
		msg=iae.toString()+" "+target;
		System.out.println(msg);
		//file writer
		writer = new FileWriter("E:/LoggerException1.txt",true);
		writer.write("\n"+iae.getMessage());
		writer.flush();
		writer.close();
	}

}
