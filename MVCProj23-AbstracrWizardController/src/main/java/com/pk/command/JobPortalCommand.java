package com.pk.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JobPortalCommand {

	private String name;
	private String adress;
	private int age;
	private long contactNo;
	private String domain;
	private String currentCompany;
	private int experiance;
	private String preferLocation;
	private long expSalary;
	
	public JobPortalCommand() {
		System.out.println("JobPortalCommand.JobPortalCommand()");
	}
	
	
}
