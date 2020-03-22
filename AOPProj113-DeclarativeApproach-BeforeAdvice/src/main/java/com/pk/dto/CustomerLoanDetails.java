package com.pk.dto;

import lombok.Data;

@Data
public class CustomerLoanDetails {

	private String customerName;
	private long adaharNo;
	private float loanAmt;
	private String loanPurpose;
	private String clerkName;
	private String managerName;	
}
