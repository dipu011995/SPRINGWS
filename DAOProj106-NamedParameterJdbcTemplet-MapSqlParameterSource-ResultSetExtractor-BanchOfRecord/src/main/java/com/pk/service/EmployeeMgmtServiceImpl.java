package com.pk.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.EmployeeBO;
import com.pk.dao.EmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	private EmployeeDAO dao;

	public List<Map<String, Object>> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {
		
		return dao.getEmployeesByDesg(desg1, desg2, desg3);
	}

	@Override
	public List<EmployeeBO> fetchEmpsByJob(String desg1, String desg2, String desg3) {
		
		return dao.getEmpsByJob(desg1, desg2, desg3);
	}

	

}
