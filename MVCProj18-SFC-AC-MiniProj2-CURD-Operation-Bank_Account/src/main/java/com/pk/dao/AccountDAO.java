package com.pk.dao;

import java.util.List;

import com.pk.entity.AccountDetailsEntity;

public interface AccountDAO {

	public int addAccount(AccountDetailsEntity entity);

	public List<AccountDetailsEntity> getAllContact();

	public AccountDetailsEntity getAccountByAccNo(Integer accNo);

	public int updateAccountByAccNo(AccountDetailsEntity entity);
	
	public int deletAccountByAccNo(Integer accNo);
}
