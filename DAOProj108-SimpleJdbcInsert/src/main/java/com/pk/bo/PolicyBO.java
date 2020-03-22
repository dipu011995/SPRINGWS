package com.pk.bo;

import lombok.Data;

@Data
public class PolicyBO {

	private String policyName;
	private String policyType;
	private String company;
	private int term;
	private float monthlyInstalment;

}
