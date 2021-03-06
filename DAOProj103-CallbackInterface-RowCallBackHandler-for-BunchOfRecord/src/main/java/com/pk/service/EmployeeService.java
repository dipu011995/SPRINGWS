package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.EmployeeBO;
import com.pk.dao.EmployeeDAO;
import com.pk.dto.EmployeeDTO;

@Service("empService")
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	
	public List<EmployeeDTO> fetchEmployeeDetailsByJob(String desg1,String desg2,String desg3) throws Exception{
		List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		//use dao
		listBO = dao.getEmployeeByJob(desg1, desg2, desg3);
		//copy listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
}
