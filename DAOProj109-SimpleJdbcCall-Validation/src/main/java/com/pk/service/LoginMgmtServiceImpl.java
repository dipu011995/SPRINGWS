package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.LoginBO;
import com.pk.dao.LoginDAO;
import com.pk.dto.LoginDTO;

@Service("empService")
public class LoginMgmtServiceImpl implements LoginMgmtService {

	@Autowired
	private LoginDAO dao;

	public String authenticate(LoginDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
