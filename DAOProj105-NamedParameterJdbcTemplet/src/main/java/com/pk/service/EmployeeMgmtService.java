package com.pk.service;

import java.util.Map;

public interface EmployeeMgmtService {

	public Map<String, Object> fetchEmployeeDetailsBYNo(int no) throws Exception;
	public String fetchEmployeeDetailsByNo(int no) throws Exception;
}
