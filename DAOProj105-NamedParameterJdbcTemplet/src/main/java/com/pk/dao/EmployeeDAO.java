package com.pk.dao;

import java.util.Map;

public interface EmployeeDAO {

	public Map<String,Object> findEmployeeDetailsBYNo(int no) throws Exception; 
	public String findEmployeeNameByNo(int no) throws Exception;
}
