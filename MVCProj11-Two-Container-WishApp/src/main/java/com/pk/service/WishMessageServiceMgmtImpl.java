package com.pk.service;

import java.util.Calendar;

public class WishMessageServiceMgmtImpl implements WishMessageServiceMgmt {

	@Override
	public String getWishMessage() {
		Calendar calender = null;
		int hour = 0;
		//get calender obj
		calender = Calendar.getInstance();
		//get current hour
		hour = calender.get(Calendar.HOUR_OF_DAY);
		//get name from req param
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";

	}

}
