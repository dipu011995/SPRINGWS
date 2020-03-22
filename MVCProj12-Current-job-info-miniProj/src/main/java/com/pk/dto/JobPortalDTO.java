package com.pk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobPortalDTO implements Serializable{
	
	private int slNo;
	private int jobId;
	private String companyName;
	private String position;
	private String jobProfile;
	private int noOfPosition;
	private String expRange;
	private String salaryrange;
	private String location;

}
