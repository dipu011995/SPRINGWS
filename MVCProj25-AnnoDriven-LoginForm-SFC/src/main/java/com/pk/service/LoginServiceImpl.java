package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.UserBO;
import com.pk.dao.LoginDAO;
import com.pk.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO dao;
	
	@Override
	public String authenticate(UserDTO dto) {
		int count ;
		UserBO bo = null;
		
		bo = new UserBO();
		BeanUtils.copyProperties(dto, bo);
		count = dao.validate(bo);
		
		return (count==0) ? "Invalid Credential" : "Valid Credential" ;
	}

}
