package com.pk.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.pk.cmdClass.PatientCommand;
import com.pk.dto.PatientInputDTO;
import com.pk.service.PatientSearchMgmtService;

public class PatientController extends AbstractCommandController {

	private PatientSearchMgmtService service;

	public PatientController(PatientSearchMgmtService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		PatientCommand cmd = null;
		PatientInputDTO inputDTO = null;
		ModelAndView mav = null;
		
		//set command class obj
		cmd = (PatientCommand) command;

		// convert cmdClass obj to dto
		inputDTO = new PatientInputDTO();
		BeanUtils.copyProperties(cmd, inputDTO);
		// set value to mav obj
		mav = new ModelAndView();
		mav.setViewName("patient_details");
		mav.addObject("patientDetails", service.searchPatient(inputDTO));
		mav.addObject("sysDate", new Date());
		return mav;
	}

}
