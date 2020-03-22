package com.pk.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.dao.EmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	
	@Autowired
	private EmployeeDAO dao;

	public Map<String, Object> fetchEmployeeDetailsBYNo(int no) throws Exception {
		
		return dao.findEmployeeDetailsBYNo(no);
	}

	public String fetchEmployeeDetailsByNo(int no) throws Exception {
		
		return dao.findEmployeeNameByNo(no);
	}

}
