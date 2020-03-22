package com.pk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.pk.command.JobPortalCommand;

public class JobPortalRegisterController extends AbstractWizardFormController {

	@Override
	public ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		JobPortalCommand cmd = null;
		
		cmd = (JobPortalCommand) command;
		System.out.println(cmd);
		
		return new ModelAndView("welcome", "result", cmd);
	}
	
	@Override
	public ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		return new ModelAndView("welcome");
	}

}
