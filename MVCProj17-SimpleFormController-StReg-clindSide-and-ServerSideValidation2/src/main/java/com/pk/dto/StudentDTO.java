package com.pk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO  implements Serializable{
	
	private int slNo;
	private String sname;
	private String saddrs;
	private String course;
	private String branch;
	private long mob;

}
