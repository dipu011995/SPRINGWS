package com.pk.manager;

public interface AuthenticationManager {

	public void login(String user,String pwd);
	public void logout();
	public boolean validate();
}
