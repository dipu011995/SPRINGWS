package com.pk.service;

import java.util.List;

import com.pk.bo.CustomerBO;
import com.pk.dto.CustomerDTO;

public interface BankMgmtService {

	public CustomerDTO fetchEmpDetailsById(int id);
	public List<CustomerDTO> fetchCustomersDetailsByBalanceRange(float minBal, float maxBal) ;
}
