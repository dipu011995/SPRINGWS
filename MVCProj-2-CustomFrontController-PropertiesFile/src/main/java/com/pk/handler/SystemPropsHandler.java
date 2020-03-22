package com.pk.handler;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemPropsHandler implements SystemHandler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		
		Properties props =System.getProperties();
		
		//set value to req parameter
		req.setAttribute("result", props);
		
		//return logical view name
		return "show_props";
	}

}
