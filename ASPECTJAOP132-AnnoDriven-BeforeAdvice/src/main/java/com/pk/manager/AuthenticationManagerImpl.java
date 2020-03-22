package com.pk.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pk.dao.AuthenticationDAO;
import com.pk.model.LoginDetails;

@Component("authManager")
public class AuthenticationManagerImpl implements AuthenticationManager{
	
	private ThreadLocal<LoginDetails> threadLocal = new ThreadLocal();
	
	@Autowired
	@Qualifier(value = "authDAO")
	private AuthenticationDAO dao;

	public void login(String user, String pwd) {
		System.out.println("AuthenticationManagerImpl.login()");
		LoginDetails details = null;
		details = new LoginDetails();
		//set value to LoginDetails obj
		details.setUserName(user);
		details.setPassword(pwd);
		//set values to ThreadLocal obj
		threadLocal.set(details);
	}

	public void logout() {
		System.out.println("AuthenticationManagerImpl.logout()");
		threadLocal.remove();		
	}

	public boolean validate() {
		System.out.println("AuthenticationManagerImpl.validate()");
		LoginDetails details = null;
		int count = 0;
		//get details from thread local
		details = threadLocal.get();
		//use DAO
		count = dao.authenticate(details);
		if(count==0)
			return false;
		else
			return true;
	}

}
