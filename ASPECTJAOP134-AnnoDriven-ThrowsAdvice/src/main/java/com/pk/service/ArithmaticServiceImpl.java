package com.pk.service;

import org.springframework.stereotype.Service;

@Service("arithmaticService")
public class ArithmaticServiceImpl implements ArithmaticService {

	public float div(int x, int y) {	
		return x/y;
	}

}
