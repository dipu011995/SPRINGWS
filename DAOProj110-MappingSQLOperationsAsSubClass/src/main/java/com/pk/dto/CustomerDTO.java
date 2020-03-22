package com.pk.dto;

import lombok.Data;

@Data
public class CustomerDTO {

	private int slNo;
	private int custID;
	private String custName;
	private String custAddrs;
	private float balance;
}
