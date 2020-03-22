package com.pk.service;

import java.util.Calendar;

public class WishMessageServiceImpl implements WishMessageService {

	public String generateWishMessage() {
		Calendar calender = null;
		int hour = 0;
		String msg = null;
		//get calender obj
		calender = Calendar.getInstance();
		//get current hour
		hour = calender.get(Calendar.HOUR_OF_DAY);
		//get name from req param
		if(hour<12)
			msg = "Good Morning";
		else if(hour<16)
			msg = "Good AfterNoon";
		else if(hour<20)
			msg = "Good Evening";
		else
			msg = "Good Night";
		return msg;
	}

}
