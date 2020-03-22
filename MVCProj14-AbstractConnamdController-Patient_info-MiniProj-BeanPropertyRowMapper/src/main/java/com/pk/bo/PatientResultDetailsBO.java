package com.pk.bo;

import com.pk.dto.PatientInputDTO;

import lombok.Data;

@Data
public class PatientResultDetailsBO extends PatientInputDTO {
	
	private int pid;
	private int age;
	private String gender;
	private int wordNo;
	private long contact;

}
