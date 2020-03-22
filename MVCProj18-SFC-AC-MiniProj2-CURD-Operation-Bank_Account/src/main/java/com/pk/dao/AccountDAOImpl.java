package com.pk.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.pk.entity.AccountDetailsEntity;

public class AccountDAOImpl implements AccountDAO {
	private static final String ADD_ACC_DETAILS_QUERY = "INSERT INTO BANK_ACCOUNT (ACC_NO,ACC_HLDR_NAME,ADRESS,ADHAR_NO,BALANCE,MOB) VALUES (ACNO_SEQ.NEXTVAL,?,?,?,?,?) ";
	private static final String GET_ALL_ACC_DETAILS_QUERY = "SELECT  ACC_NO,ACC_HLDR_NAME,ADRESS,ADHAR_NO,BALANCE,MOB FROM BANK_ACCOUNT";
	private static final String DET_ACCOUNT_BY_ACCNO = "SELECT ACC_NO,ACC_HLDR_NAME,ADRESS,ADHAR_NO,BALANCE,MOB FROM BANK_ACCOUNT WHERE ACC_NO = ?";
	private static final String UPDATE_ACCOUNT_BY_ACCNO = "UPDATE BANK_ACCOUNT SET ACC_HLDR_NAME = ?,ADRESS = ?, ADHAR_NO = ?, BALANCE = ?, MOB = ? WHERE ACC_NO = ? ";
	private static final String DELETE_ACCOUNT_BY_ACCNO = " DELETE FROM BANK_ACCOUNT WHERE ACC_NO = ? ";
	
	private JdbcTemplate jt;

	public AccountDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int addAccount(AccountDetailsEntity entity) {
		return jt.update(ADD_ACC_DETAILS_QUERY, entity.getAccHldrName(), entity.getAdress(), entity.getAdharNo(),
				entity.getBalance(), entity.getMob());
	}

	@Override
	public List<AccountDetailsEntity> getAllContact() {
		List<AccountDetailsEntity> listEntity = null;
		listEntity = (List<AccountDetailsEntity>) jt.query(GET_ALL_ACC_DETAILS_QUERY,
				new RowMapperResultSetExtractor(new BeanPropertyRowMapper(AccountDetailsEntity.class)));
		return listEntity;
	}

	@Override
	public AccountDetailsEntity getAccountByAccNo(Integer accNo) {
		return jt.queryForObject(DET_ACCOUNT_BY_ACCNO, new BeanPropertyRowMapper<>(AccountDetailsEntity.class), accNo);
	}

	@Override
	public int updateAccountByAccNo(AccountDetailsEntity entity) {
		return jt.update(UPDATE_ACCOUNT_BY_ACCNO, entity.getAccHldrName(), entity.getAdress(), entity.getAdharNo(),
				entity.getBalance(), entity.getMob(), entity.getAccNo());
	}

	@Override
	public int deletAccountByAccNo(Integer accNo) {
		return jt.update(DELETE_ACCOUNT_BY_ACCNO,accNo);
	}
}
