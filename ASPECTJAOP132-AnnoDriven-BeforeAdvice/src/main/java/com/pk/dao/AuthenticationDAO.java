package com.pk.dao;

import com.pk.model.LoginDetails;

public interface AuthenticationDAO {

	public int authenticate(LoginDetails details);
}
