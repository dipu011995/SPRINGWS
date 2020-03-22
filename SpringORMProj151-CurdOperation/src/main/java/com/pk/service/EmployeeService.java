package com.pk.service;

import com.pk.dto.EmployeeDTO;

public interface EmployeeService {

	public int addEmployee(EmployeeDTO dto);
	public EmployeeDTO fetchEmployeeById(int id);
	public void updateEmployee(EmployeeDTO dto);
}
