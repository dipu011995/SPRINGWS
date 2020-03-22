package com.pk.service;

import java.util.List;

import com.pk.dto.AccountDetailsDTO;

public interface BankMgmtService {

	public String openAccount(AccountDetailsDTO dto);

	public List<AccountDetailsDTO> fetchAllAccount();

	public AccountDetailsDTO fetchAccountByAccNo(Integer accNo);

	public String modifyAccountByAccNo(AccountDetailsDTO dto);
	
	public String removeAccountByAccNo(Integer accNo);
}
