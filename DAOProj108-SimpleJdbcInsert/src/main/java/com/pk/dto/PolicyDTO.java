package com.pk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PolicyDTO implements Serializable{
	
	private String policyName;
	private String policyType;
	private String company;
	private int term;
	private float monthlyInstalment;

}
