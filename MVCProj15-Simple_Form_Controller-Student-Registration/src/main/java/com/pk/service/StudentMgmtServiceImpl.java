package com.pk.service;

import org.springframework.beans.BeanUtils;

import com.pk.bo.StudentBO;
import com.pk.dao.StudentDAO;
import com.pk.dto.StudentDTO;

public class StudentMgmtServiceImpl implements StudentMgmtService {

	private StudentDAO dao;
	
	public StudentMgmtServiceImpl(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public String saveStudent(StudentDTO dto) {
		StudentBO bo = null;
		int result = 0;
		
		//convert dto to bo
		bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		result = dao.addStudent(bo);
		if(result==0)
			return "Student Registration Failed";
		else
			return "Student Registration Sucessed";
	}
}
