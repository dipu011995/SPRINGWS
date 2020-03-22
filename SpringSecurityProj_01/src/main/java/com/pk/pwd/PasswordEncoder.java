package com.pk.pwd;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String hashPwd1 = passwordEncoder.encode("kumar");
		String hashPwd2 = passwordEncoder.encode("alam");
		String hashPwd3 = passwordEncoder.encode("singh");
		
		System.out.println(hashPwd1+"     "+hashPwd2+"     "+hashPwd2);
	}

}
