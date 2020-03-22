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
		//copy cmd to dto
		 dto = new StudentDTO();
		 
		 //application error logic
		 if(String.valueOf(cmd.getMob()).length() != 10) {
			 errors.rejectValue("mob", "st.mob.length");
			 return showForm(request, response, errors);
		 }
			 
		 
		 BeanUtils.copyProperties(cmd, dto);
		//use service
		 outputResult = service.saveStudent(dto);
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
