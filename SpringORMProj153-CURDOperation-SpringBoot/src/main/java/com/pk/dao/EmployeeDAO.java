package com.pk.dao;

import java.util.List;

import com.pk.entity.EmployeeEntity;


public interface EmployeeDAO {
	
	public List<EmployeeEntity> getEmployeeByDesgByPositionalParameter(String desg1,String desg2);
	public List<EmployeeEntity> getEmployeeByDesgByNamedParameter(String desg1,String desg2);
	public List<EmployeeEntity> getEmployeebySalRangeTakingGlobalNamedQuery(float minSal,float MaxSal);
	public int fireEmployeebySalarymark(float markSalary);
	
	public int updateEmpSalaryByDesg(String desg, float percentage);
}
