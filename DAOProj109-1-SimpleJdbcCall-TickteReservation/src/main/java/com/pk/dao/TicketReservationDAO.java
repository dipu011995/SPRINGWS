package com.pk.dao;


import com.pk.bo.TicketReservationBO;

public interface TicketReservationDAO {

	public TicketReservationBO getPassengerDetails(int pid);
}
