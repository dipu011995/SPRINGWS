package com.pk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pk.service.WishMessageServiceMgmt;

public class WishMessageGenerator  extends AbstractController{

	private WishMessageServiceMgmt service;
	
	public WishMessageGenerator(WishMessageServiceMgmt service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String msg = null;
		//use service
		msg = service.getWishMessage();
		
		return new ModelAndView("result", "wsmg", msg);
	}
		
}
