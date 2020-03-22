package com.pk.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageGenerator  extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Calendar calender = null;
		int hour = 0;
		String msg = null;
		String name = null;
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
		
		return new ModelAndView("result", "wsmg", msg);
	}
		
}
