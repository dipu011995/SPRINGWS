package com.pk.entity;

import org.springframework.data.annotation.Id;

public class EmployeeEntity {
	
	@Id
	private int eid;

	private String ename;
	private String desg;
	private String salary;
	
}
