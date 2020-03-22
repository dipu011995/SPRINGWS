package com.pk.service;

import java.util.Random;

public class AtmPinGenerationServiceImpl implements AtmPinGenerationService {

	public int generateATMPin() {
		System.out.println("AtmPinGenerationServiceImpl.generateATMPin()");
		return new Random().nextInt(10000);
	}

}
