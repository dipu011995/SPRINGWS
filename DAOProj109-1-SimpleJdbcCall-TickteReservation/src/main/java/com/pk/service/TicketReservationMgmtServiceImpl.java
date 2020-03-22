package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.TicketReservationBO;
import com.pk.dao.TicketReservationDAO;
import com.pk.dto.TicketReservationDTO;

@Service("reservationService")
public class TicketReservationMgmtServiceImpl implements TicketReservationMgmtService {

	@Autowired
	private TicketReservationDAO dao;

	public TicketReservationDTO fetchPassengerDetails(int pid) {
		TicketReservationBO bo = null;
		TicketReservationDTO dto = null;
		
		//use dao
		bo = dao.getPassengerDetails(pid);
		//convert resulrSet to dto obj
		dto = new TicketReservationDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	
	

}
