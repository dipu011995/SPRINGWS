package com.pk.service;

import org.springframework.stereotype.Component;

@Component("calcService")
public class CalculatorServiceimpl implements CalculatorService {

	public int addNumber(int a, int b) {
		return a+b;
	}

}
