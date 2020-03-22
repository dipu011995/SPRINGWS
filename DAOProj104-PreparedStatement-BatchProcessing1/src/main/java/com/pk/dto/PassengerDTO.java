package com.pk.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class PassengerDTO {

	private String passengerName;
	private byte age;
	private String gender;
	private String source;
	private String destination;
	private Date journeyDate;
}
