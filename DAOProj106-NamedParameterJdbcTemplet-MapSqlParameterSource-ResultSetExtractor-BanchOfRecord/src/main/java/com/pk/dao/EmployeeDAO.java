package com.pk.dao;

import java.util.List;
import java.util.Map;

import com.pk.bo.EmployeeBO;

public interface EmployeeDAO {

	public List<Map<String,Object>> getEmployeesByDesg(String desg1,String desg2,String desg3);
	public List<EmployeeBO> getEmpsByJob(String desg1,String desg2,String desg3);
}
