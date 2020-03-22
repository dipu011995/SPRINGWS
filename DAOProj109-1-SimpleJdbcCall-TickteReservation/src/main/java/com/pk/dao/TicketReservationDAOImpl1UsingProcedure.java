package com.pk.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.pk.bo.TicketReservationBO;


@Repository("reservationDAOProcedure")
//@Primary
public class TicketReservationDAOImpl1UsingProcedure implements TicketReservationDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;

	/*public TicketReservationBO getPassengerDetails(int pid) {
		Map<String, Object> inParamSource = null;
		Map<String, Object> outParamMap = null;
		TicketReservationBO bo = null;
		
		//set procedure
		sjc.setProcedureName("P_GET_PASSENGER_DETAILS");
		//prepare paramSource
		inParamSource = new HashMap();
		inParamSource.put("PID", pid);
		
		//get Result
		outParamMap =  sjc.execute(inParamSource);
	
		//convert resulrSet to bo obj
		bo = new TicketReservationBO();
		bo.setPsngrName((String) outParamMap.get("PNAME"));
		bo.setPsngrMob(Long.parseLong((String) outParamMap.get("MOB")));
		bo.setJourneySource((String) outParamMap.get("SOURCE"));
		bo.setJourneyDestination((String) outParamMap.get("DESTINATION"));
		return bo;
	}*/
	
	public TicketReservationBO getPassengerDetails(int pid) {
		Map<String, Object> outParamMap = null;
		MapSqlParameterSource inParamSource = null;
		
		TicketReservationBO bo = null;
		
		//set procedure
		sjc.setProcedureName("P_GET_PASSENGER_DETAILS");
		//prepare paramSource
		inParamSource = new MapSqlParameterSource();
		inParamSource.addValue("PID", "pid");
		
		//get Result
		outParamMap =  sjc.execute(inParamSource);
	
				
		//convert resulrSet to bo obj
		bo = new TicketReservationBO();
		bo.setPsngrName((String) outParamMap.get("PNAME"));
		bo.setPsngrMob(Long.parseLong((String) outParamMap.get("MOB")));
		bo.setJourneySource((String) outParamMap.get("SOURCE"));
		bo.setJourneyDestination((String) outParamMap.get("DESTINATION"));
		return bo;
	}
	
}
