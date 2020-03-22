package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.EmployeeDAO;
import com.pk.dto.EmployeeDTO;
import com.pk.entity.EmployeeEntity;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addEmployee(EmployeeDTO dto) {
		EmployeeEntity entity = null;
		
		entity = new EmployeeEntity();
		//copy dto to entity
		BeanUtils.copyProperties(dto, entity);
		//use dao
		return dao.saveEmployee(entity);
	}

	@Override
	public EmployeeDTO fetchEmployeeById(int id) {
		EmployeeEntity entity = null;
		EmployeeDTO dto = null;
		
		//use dao
		entity = dao.getEmployeeById(id);
		//convert entity to dto
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}
	
	@Override
	public void updateEmployee(EmployeeDTO dto) {
		EmployeeEntity entity = null;
		entity = new EmployeeEntity();
		
		BeanUtils.copyProperties(dto, entity);
		//use dao
		dao.updateEmployee(entity);
				
	}

}
