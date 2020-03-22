package com.pk.aspect;

import org.aspectj.lang.JoinPoint;
import com.pk.manager.AuthenticationManager;

public class SecurityCheckAspect  {

	private AuthenticationManager manager;

	public SecurityCheckAspect(AuthenticationManager manager) {
		this.manager = manager;
	}

		private void checkCredential(JoinPoint jp) throws Throwable{
			System.out.println("SecurityCheckAspect.securityCheck()");
			if(!manager.validate())
				throw  new IllegalArgumentException("Invalid Crediantial");
		}
	
	/*private void checkCredential(int accNo,float amt) throws Throwable {
		System.out.println("SecurityCheckAspect.securityCheck()");
		if(!manager.validate())
			throw  new IllegalArgumentException("Invalid Crediantial");
	}*/

}
