package com.pk.bo;

import lombok.Data;

@Data
public class TicketReservationBO {

	private String psngrName;
	private long psngrMob;
	private String journeySource;
	private String journeyDestination;
}
