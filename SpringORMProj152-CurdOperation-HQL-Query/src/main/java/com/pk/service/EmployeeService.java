package com.pk.service;

import java.util.List;

import com.pk.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> fetchEmployeeByDesgUsingPparam(String desg1,String desg2);

	public List<EmployeeDTO> fetchEmployeeByDesgUsingNparam(String desg1,String desg2);
	
	public List<EmployeeDTO> fetchEmployeebySalRangeTakingGlobalNamedQuery(float minSal,float maxSal);
	
	public int removeEmployeebySalarymark(float markSalary);
	
	
	
	public int hikeEmpSalaryByDesg(String desg, float percentage);
}
