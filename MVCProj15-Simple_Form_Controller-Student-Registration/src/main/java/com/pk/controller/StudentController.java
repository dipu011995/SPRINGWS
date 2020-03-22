package com.pk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.pk.command.StudentCommand;
import com.pk.dto.StudentDTO;
import com.pk.service.StudentMgmtService;

public class StudentController extends SimpleFormController {
	
	private StudentMgmtService service;
	
	public StudentController(StudentMgmtService service) {
		this.service = service;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		StudentCommand cmd = null;
		StudentDTO dto = null;
		String outputResult = null;
		ModelAndView mav = null;
		//set command value to cmd(StudentCommand type)
		 cmd = (StudentCommand) command;
		 System.out.println(cmd);
		//copy cmd to dto
		 dto = new StudentDTO();
		 BeanUtils.copyProperties(cmd, dto);
		 System.out.println(dto);
		//use service
		 outputResult = service.saveStudent(dto);
		 System.out.println(outputResult);
		//mav obj
		 mav = new ModelAndView();
		 mav.setViewName("result");
		 mav.addObject("resMsg", outputResult);
		return mav;
	}
	
	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return new ModelAndView("error");
	}
}
