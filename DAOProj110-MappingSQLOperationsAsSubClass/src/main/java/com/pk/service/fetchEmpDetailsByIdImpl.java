package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.CustomerBO;
import com.pk.dao.BankCustomerDAO;
import com.pk.dto.CustomerDTO;

@Service("custService")
public class fetchEmpDetailsByIdImpl implements BankMgmtService {

	@Autowired
	private BankCustomerDAO dao;
	
	public CustomerDTO fetchEmpDetailsById(int id) {
		int count = 0;
		CustomerBO bo = null;
		CustomerDTO dto = null;
		//use dao
		bo = dao.getEmpDetailsById(id);
		//copy bo to dto
		dto = new CustomerDTO();
		dto.setSlNo(1);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	public List<CustomerDTO> fetchCustomersDetailsByBalanceRange(float minBal, float maxBal) {
		List<CustomerBO> listBO = null;
		List<CustomerDTO> listDTO = new ArrayList<CustomerDTO>();
		//use dao
		listBO = dao.getCustomersDetailsByBalanceRange(minBal, maxBal);
		//copy result
		listBO.forEach(bo->{
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});		
		return listDTO;
	}

}
