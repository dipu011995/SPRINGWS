package com.pk.service;

import com.pk.dto.UserDTO;


public interface LoginService {
	
	public String authenticate(UserDTO dto);
	
}
