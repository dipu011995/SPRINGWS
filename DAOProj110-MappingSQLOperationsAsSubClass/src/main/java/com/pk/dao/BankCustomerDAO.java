package com.pk.dao;

import java.util.List;

import com.pk.bo.CustomerBO;

public interface BankCustomerDAO {

	public CustomerBO getEmpDetailsById(int id);
	public List<CustomerBO> getCustomersDetailsByBalanceRange(float minBal,float maxBal);
}
