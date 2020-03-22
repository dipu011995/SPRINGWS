package com.pk.dao;

import com.pk.entity.EmployeeEntity;

public interface EmployeeDAO {
	
	public int saveEmployee(EmployeeEntity empEntity);
	public EmployeeEntity getEmployeeById(int id);
	public void updateEmployee(EmployeeEntity emp);

}
