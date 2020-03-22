package com.pk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pk.dto.AccountDetailsDTO;
import com.pk.service.BankMgmtService;

public class DeleteAccountController extends AbstractController {

	private BankMgmtService service;

	public DeleteAccountController(BankMgmtService service) {
		System.out.println("DeleteAccountController.DeleteAccountController()");
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String acno = null;
		Integer accNo = 0;
		String deletionResultMsg = null;
		ModelAndView mav = null;
		List<AccountDetailsDTO> listDTO = null;

		acno = req.getParameter("accNo");
		System.out.println(acno);
		
			accNo = Integer.parseInt(acno);
			System.out.println(accNo);
		
		deletionResultMsg = service.removeAccountByAccNo(accNo);
		listDTO = service.fetchAllAccount();
		
		mav = new ModelAndView();
		mav.addObject("deletionResultMsg", deletionResultMsg);
		mav.addObject("delAccList", listDTO);
		mav.setViewName("delet_account_Result");

		return mav;
	}

}
