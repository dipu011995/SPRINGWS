package com.pk.dao;

import java.util.Map;

import com.pk.bo.LoginBO;

public interface LoginDAO {

	public Map<String, Object> validate(LoginBO bo);
}
