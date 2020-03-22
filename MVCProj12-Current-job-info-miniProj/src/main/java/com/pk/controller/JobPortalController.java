package com.pk.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pk.dto.JobPortalDTO;
import com.pk.service.JobPortalMgmtService;

public class JobPortalController extends AbstractController {
	
	private JobPortalMgmtService service;

	public JobPortalController(JobPortalMgmtService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<JobPortalDTO> listDTO = null;
		ModelAndView mav = null;
		//use service
		listDTO = service.findAllCurretntTrendingJob();
		
		mav = new ModelAndView();
		mav.addObject("jobList", listDTO);
		mav.addObject("sysDate", new Date());
		mav.setViewName("job_details");
		
		return mav;
		//return new ModelAndView("job_details", "jobList", listDTO);
	}
	
		

}
