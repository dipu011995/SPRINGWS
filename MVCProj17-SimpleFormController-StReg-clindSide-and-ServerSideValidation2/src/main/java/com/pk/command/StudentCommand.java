package com.pk.command;

import lombok.Data;

@Data
public class StudentCommand {

	private String sname;
	private String saddrs;
	private String course;
	private String branch;
	private Long mob;
	private boolean vflag = false;
}
