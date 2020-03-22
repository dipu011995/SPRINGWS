package com.pk.dto;

import java.io.Serializable;

import lombok.Data;


@Data 
public class EmployeeDTO implements Serializable {
	
	private int eid;
	private String ename;
	private String desg;
	private float salary;

}
