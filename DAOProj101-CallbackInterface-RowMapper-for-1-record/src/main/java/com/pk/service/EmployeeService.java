package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.EmployeeBO;
import com.pk.dao.EmployeeDAO;
import com.pk.dto.EmployeeDTO;

@Service("empService")
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	
	public EmployeeDTO fetchEmpDetailsByNo(int no) {
		EmployeeDTO dto = null;
		EmployeeBO bo = null;
		//use dao
		bo = dao.getEMpDetailsByNo(no);
		
		//create dto obj and copy bo to dto 
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	
}
