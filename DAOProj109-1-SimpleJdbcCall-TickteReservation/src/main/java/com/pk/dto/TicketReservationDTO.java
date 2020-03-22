package com.pk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TicketReservationDTO implements Serializable{

	private String psngrName;
	private long psngrMob;
	private String journeySource;
	private String journeyDestination;

}
