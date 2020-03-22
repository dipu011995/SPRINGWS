package com.pk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pk.dto.AccountDetailsDTO;
import com.pk.service.BankMgmtService;

public class ViewAccountDetailsController extends AbstractController {
	
	private BankMgmtService service;
	
	public ViewAccountDetailsController(BankMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<AccountDetailsDTO> listDTO = null;
		ModelAndView mav = null;
		
		listDTO = service.fetchAllAccount();
		mav = new ModelAndView();
		mav.addObject("accList", listDTO);
		mav.setViewName("view_details");
		return mav;
	}

}
