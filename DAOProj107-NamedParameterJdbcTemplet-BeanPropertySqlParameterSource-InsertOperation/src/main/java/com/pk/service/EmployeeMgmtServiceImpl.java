package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.EmployeeBO;
import com.pk.dao.EmployeeDAO;
import com.pk.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		EmployeeBO bo = null;
		int result = 0;
		bo = new EmployeeBO();
		//copy empBO to empDTO
		BeanUtils.copyProperties(dto, bo);
		//use dao
		result = dao.insertEmployee(bo);
		if(result==0)
			return "Registration Failed";
		else
			return "Registration Sucessed";
	}//insertEmployee

	
	

}
