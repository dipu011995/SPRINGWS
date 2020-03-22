package com.pk.bo;

import lombok.Data;

@Data
public class CustomerBO {

	private int custID;
	private String custName;
	private String custAddrs;
	private float balance;
}
