package com.pk.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<EmployeeDTO> fetchEmployeeByDesgUsingPparam(String desg1, String desg2) {
		List<EmployeeEntity> empEntity = null;
		List<EmployeeDTO> empDTO = null;
		
		//usr DAO
		empEntity= dao.getEmployeeByDesgByPositionalParameter(desg1, desg2);
		//create Arraylist obj
		empDTO = new ArrayList<EmployeeDTO>();
		// copy empList toempDTO
		for (EmployeeEntity entity : empEntity) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			empDTO.add(dto);
		}
		return empDTO;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeeByDesgUsingNparam(String desg1, String desg2) {
		List<EmployeeEntity> empEntity = null;
		List<EmployeeDTO> empDTO = null;
		
		//usr DAO
		empEntity= dao.getEmployeeByDesgByNamedParameter(desg1, desg2);
		//create Arraylist obj
		empDTO = new ArrayList<EmployeeDTO>();
		// copy empList toempDTO
		for (EmployeeEntity entity : empEntity) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			empDTO.add(dto);
		}
		return empDTO;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeebySalRangeTakingGlobalNamedQuery(float minSal, float maxSal) {
		List<EmployeeEntity> empEntity = null;
		List<EmployeeDTO> empDTO = null;
		
		//usr DAO
		empEntity= dao.getEmployeebySalRangeTakingGlobalNamedQuery(minSal, maxSal);
		//create Arraylist obj
		empDTO = new ArrayList<EmployeeDTO>();
		// copy empList toempDTO
		for (EmployeeEntity entity : empEntity) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(entity, dto);
			empDTO.add(dto);
		}
		return empDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int removeEmployeebySalarymark(float markSalary) {
		return dao.fireEmployeebySalarymark(markSalary);
	}

	
	
	@Override
	public int hikeEmpSalaryByDesg(String desg, float percentage) {
		return dao.updateEmpSalaryByDesg(desg, percentage);
	}
	


}
