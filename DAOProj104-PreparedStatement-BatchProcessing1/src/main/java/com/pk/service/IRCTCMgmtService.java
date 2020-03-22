package com.pk.service;

import java.util.List;

import com.pk.dto.PassengerDTO;

public interface IRCTCMgmtService {

	public String reserveTicket(List<PassengerDTO> listDTO) throws Exception;
}
