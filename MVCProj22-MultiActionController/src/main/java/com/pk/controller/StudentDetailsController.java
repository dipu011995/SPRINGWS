package com.pk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.pk.command.StudentCommand;

public class StudentDetailsController extends MultiActionController {
	
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse res,StudentCommand cmd) {
		System.out.println("StudentDetailsController.insert()");
		return  new ModelAndView("user", "operation", "Data Inserted");
	}
	public ModelAndView delet(HttpServletRequest req, HttpServletResponse res,StudentCommand cmd) {
		System.out.println("StudentDetailsController.delet()");
		return  new ModelAndView("user", "operation", "Data Deleted");
	}
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res,StudentCommand cmd) {
		System.out.println("StudentDetailsController.update()");
		return  new ModelAndView("user", "operation", "Data Updated");
	}
	public ModelAndView view(HttpServletRequest req, HttpServletResponse res,StudentCommand cmd) {
		System.out.println("StudentDetailsController.view()");
		return  new ModelAndView("user", "operation", "View Result");
	}

}
