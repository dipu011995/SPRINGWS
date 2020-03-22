package com.pk.dto;

import lombok.Data;

@Data
public class PatientResultDetailsDTO extends PatientInputDTO {
	
	private int pid;
	private int age;
	private String gender;
	private int wordNo;
	private long contact;

}
