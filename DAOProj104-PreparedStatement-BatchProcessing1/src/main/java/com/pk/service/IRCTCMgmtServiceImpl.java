package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.PassengerBO;
import com.pk.dao.ReservationDAO;
import com.pk.dto.PassengerDTO;

@Service("passengerService")
public class IRCTCMgmtServiceImpl implements IRCTCMgmtService {
	
	@Autowired
	private ReservationDAO dao;

	public String reserveTicket(List<PassengerDTO> listDTO) throws Exception {
		List<PassengerBO> listBO =  new ArrayList<PassengerBO>();
		int[] result = null;
		
		listDTO.forEach(dto->{
			PassengerBO bo = new PassengerBO();
			BeanUtils.copyProperties(dto, bo);
			listBO.add(bo);
		});
		//use dao
		result = dao.insertPassengersData(listBO);
		if(result!=null) {
			return "Resistration Sucessed";
			/*if(result[0]==1)
				return "Resistration Sucessed";
			else
				return "Resistration Failed";*/
		}//outer If
		else {
			return "Resistration Failed";
		}
	}

}
