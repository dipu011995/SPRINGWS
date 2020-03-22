package com.pk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.pk.command.AccountDetails;
import com.pk.dto.AccountDetailsDTO;
import com.pk.service.BankMgmtService;

public class EditAccountDetailsController extends SimpleFormController{
	
	private BankMgmtService service;
	
	public EditAccountDetailsController(BankMgmtService service) {
		this.service = service;
	}

	@Override
	public Object formBackingObject(HttpServletRequest req) throws Exception {
		int accNo = 0;
		AccountDetailsDTO dto = null;
		AccountDetails cmd = null;
		//req param
		accNo = Integer.parseInt(req.getParameter("accNo"));
		//use service
		dto = service.fetchAccountByAccNo(accNo);
		//convert dto to cmd
		cmd = new AccountDetails();
		BeanUtils.copyProperties(dto, cmd);
		
		return cmd;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("EditAccountDetailsController.onSubmit()");
		AccountDetails cmd = null;
		AccountDetailsDTO dto = null;
		String updateMsg = null;
		ModelAndView mav = null;
		List<AccountDetailsDTO> listDTO = null;
		
		//set command to cmd
		cmd = (AccountDetails) command;
		//convert cmd to dto
		dto = new AccountDetailsDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use Service to update record
		 updateMsg = service.modifyAccountByAccNo(dto);
		 //get All the record After Modification
		 listDTO = service.fetchAllAccount();
		 //set data to Model 
		 mav = new ModelAndView();
		 mav.addObject("updateMsg", updateMsg);
		 mav.addObject("listDTO", listDTO);
		mav.setViewName(getSuccessView());
		return mav;
	}
	
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("home");
	}
	

}
