package com.pk.service;

import com.pk.dto.CustomerLoanDetails;

public interface BankLoanService {

	public int generateLoanId(CustomerLoanDetails details) throws Exception;
	public String approveLoan(int loanId,CustomerLoanDetails details) throws Exception;
}
