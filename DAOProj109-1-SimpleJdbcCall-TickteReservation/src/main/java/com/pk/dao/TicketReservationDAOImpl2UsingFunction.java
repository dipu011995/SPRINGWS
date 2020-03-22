package com.pk.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.pk.bo.TicketReservationBO;


@Repository("reservationDAOFunction")
@Primary
public class TicketReservationDAOImpl2UsingFunction implements TicketReservationDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;

	public TicketReservationBO getPassengerDetails(int pid) {
		Map<String, Object> inParamSource = null;
		Map<String, Object> outParamMap = null;
		TicketReservationBO bo = null;
		
		//set procedure
	//	sjc.setProcedureName("P_GET_PASSENGER_DETAILS");
	
	//	 SimpleJdbcCall call = new SimpleJdbcCall(sjc).withFunctionName("GET_SUM");
		
		//		sjc.setFunction(true);
		sjc.withFunctionName("FX_GET_PASSENGER_DETAILS");
		//prepare paramSource
		//inParamSource = new HashMap();
		//inParamSource.put("PID", pid);
		
		//get Result
		sjc.returningResultSet("DETAILS", new BeanPropertyRowMapper<TicketReservationBO>());
		
		return sjc.executeFunction(TicketReservationBO.class, pid);
		
	//	outParamMap =  sjc.executeFunction(inParamSource, args)(inParamSource);	
		//outParamMap = sjc.executeFunction(Map.class, inParamSource);
	
		/*//convert resulrSet to bo obj
		bo = new TicketReservationBO();
		bo.setPsngrName((String) outParamMap.get("PNAME"));
		bo.setPsngrMob(Long.parseLong((String) outParamMap.get("MOB")));
		bo.setJourneySource((String) outParamMap.get("SOURCE"));
		bo.setJourneyDestination((String) outParamMap.get("DESTINATION"));
		return bo;*/
	}
	
	/*	public TicketReservationBO getPassengerDetails(int pid) {
			Map<String, Object> outParamMap = null;
			MapSqlParameterSource inParamSource = null;
			
			TicketReservationBO bo = null;
			
			//set procedure
			sjc.setProcedureName("P_GET_PASSENGER_DETAILS");
			//prepare paramSource
			inParamSource = new MapSqlParameterSource();
			inParamSource.addValue("PID", "pid");
			
			//get Result
			outParamMap =  sjc.executeFunction(Map.class, inParamSource);
		
					
			//convert resulrSet to bo obj
			bo = new TicketReservationBO();
			bo.setPsngrName((String) outParamMap.get("PNAME"));
			bo.setPsngrMob(Long.parseLong((String) outParamMap.get("MOB")));
			bo.setJourneySource((String) outParamMap.get("SOURCE"));
			bo.setJourneyDestination((String) outParamMap.get("DESTINATION"));
			return bo;
		}*/
	
}
