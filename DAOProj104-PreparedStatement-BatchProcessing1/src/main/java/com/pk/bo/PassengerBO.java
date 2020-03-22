package com.pk.bo;

import java.sql.Date;

import lombok.Data;

@Data
public class PassengerBO {

	private String passengerName;
	private byte age;
	private String gender;
	private String source;
	private String destination;
	private Date journeyDate;
}
