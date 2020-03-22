package com.pk.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemDateHandler implements SystemHandler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		Date date = new Date();
		//set value to req parameter
		req.setAttribute("result", date);
		//relurn logical view name
		return "show_date";
	}

}
