package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pk.dao.AccountDAO;
import com.pk.dto.AccountDetailsDTO;
import com.pk.entity.AccountDetailsEntity;

public class BankMgmtServiceImpl implements BankMgmtService {

	private AccountDAO dao;

	public BankMgmtServiceImpl(AccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public String openAccount(AccountDetailsDTO dto) {
		int result = 0;
		AccountDetailsEntity entity = null;

		entity = new AccountDetailsEntity();
		BeanUtils.copyProperties(dto, entity);
		result = dao.addAccount(entity);
		return (result == 0) ? "Account creation Failed" : "Account Created Sucessfully";
	}

	@Override
	public List<AccountDetailsDTO> fetchAllAccount() {
		List<AccountDetailsEntity> listEntity = null;
		List<AccountDetailsDTO> listDTO = new ArrayList<AccountDetailsDTO>();

		listEntity = dao.getAllContact();
		listEntity.forEach(entity -> {
			AccountDetailsDTO dto = new AccountDetailsDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public AccountDetailsDTO fetchAccountByAccNo(Integer accNo) {
		AccountDetailsEntity entity = null;
		AccountDetailsDTO dto = null;
		// use dao
		entity = dao.getAccountByAccNo(accNo);
		// convert entity to dto
		dto = new AccountDetailsDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public String modifyAccountByAccNo(AccountDetailsDTO dto) {
		int result = 0;
		AccountDetailsEntity entity = null;
		// convert dto to entity
		entity = new AccountDetailsEntity();
		BeanUtils.copyProperties(dto, entity);
		// use dao
		result = dao.updateAccountByAccNo(entity);

		return (result == 0) ? "Record updation Failed" : "Record Updated Sucessfully";
	}
	
	@Override
	public String removeAccountByAccNo(Integer accNo) {
		int result = 0;
		
		result = dao.deletAccountByAccNo(accNo);
		return (result==0) ? "There Is smoe Problem In Account Deletion, Plz Try again" : "Account Deleted Sucessfully" ;
	}

}
