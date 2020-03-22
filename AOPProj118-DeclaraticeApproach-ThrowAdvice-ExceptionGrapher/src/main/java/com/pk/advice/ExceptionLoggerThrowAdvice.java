package com.pk.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

import com.pk.exception.NullValueException;

public class ExceptionLoggerThrowAdvice implements ThrowsAdvice {
	
	/*public void afterThrowing(IllegalArgumentException iae) throws IOException {
		Writer writer = new FileWriter("E:/LoggerException.txt");
		writer.write("Invalid values");
		writer.flush();
		writer.close();
	}*/
	
	public void afterThrowing(Throwable ie) throws IOException, NullValueException {
		System.out.println("ExceptionLoggerThrowAdvice.afterThrowing()");
		String msg = null;
		Writer writer = null;
		
		//file writer
		writer = new FileWriter("E:/LoggerException.txt",true);
		writer.write("\n"+ie.getMessage());
		writer.flush();
		writer.close();
		
		throw new NullValueException(ie.getMessage());
	}

}
