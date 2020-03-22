package com.pk.service;

import java.util.List;
import java.util.Map;

import com.pk.bo.EmployeeBO;

public interface EmployeeMgmtService {

	public List<Map<String,Object>> fetchEmployeesByDesg(String desg1,String desg2,String desg3);
	public List<EmployeeBO> fetchEmpsByJob(String desg1,String desg2,String desg3);
}
