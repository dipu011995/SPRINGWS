package com.pk.service;

import com.pk.dto.LoginDTO;

public interface LoginMgmtService {

	public String authenticate(LoginDTO dto);
}
