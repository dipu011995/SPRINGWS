package com.pk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pk.command.AccountDetails;

public class AccountDetailsValidor implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(AccountDetails.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AccountDetails cmd = null;
		
		cmd = (AccountDetails) target;

	}

}
