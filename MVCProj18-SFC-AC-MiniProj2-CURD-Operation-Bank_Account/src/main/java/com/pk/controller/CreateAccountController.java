package com.pk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.pk.command.AccountDetails;
import com.pk.dto.AccountDetailsDTO;
import com.pk.service.BankMgmtService;

public class CreateAccountController extends SimpleFormController {

	private BankMgmtService service;

	public CreateAccountController(BankMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		AccountDetails cmd = null;
		AccountDetailsDTO dto = null;
		ModelAndView mav = null;

		cmd = (AccountDetails) command;
		// convert cmd to dto
		dto = new AccountDetailsDTO();
		BeanUtils.copyProperties(cmd, dto);
		mav = new ModelAndView();
		mav.addObject("resultMsg", service.openAccount(dto));
		mav.setViewName(getSuccessView());

		return mav;
	}
	
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return new ModelAndView("home");
	}

}
