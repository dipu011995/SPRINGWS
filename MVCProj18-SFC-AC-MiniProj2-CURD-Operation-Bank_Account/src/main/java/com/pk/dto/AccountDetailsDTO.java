package com.pk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountDetailsDTO implements Serializable {

	private Long accNo;
	private String accHldrName;
	private String adress;
	private Long adharNo;
	private Float balance;
	private Long mob;

}
