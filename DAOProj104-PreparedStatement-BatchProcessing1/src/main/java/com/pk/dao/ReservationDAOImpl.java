package com.pk.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.bo.PassengerBO;

@Repository("pasengerDAO")
public class ReservationDAOImpl implements ReservationDAO {
	
	private static final String INSERT_PASSENGER_DETAILS = "INSERT INTO RESERVATION VALUES (PSG_SEQ.NEXTVAL,?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	public int[] insertPassengersData(final List<PassengerBO> listBO) throws Exception {
		int[] result = null;
		
		result = jt.batchUpdate(INSERT_PASSENGER_DETAILS, 
															new BatchPreparedStatementSetter() {
																
																public void setValues(PreparedStatement ps, int i) throws SQLException {
																	ps.setString(1, listBO.get(i).getPassengerName());
																	ps.setByte(2, listBO.get(i).getAge());
																	ps.setString(3, listBO.get(i).getGender());
																	ps.setString(4, listBO.get(i).getSource());
																	ps.setString(5, listBO.get(i).getDestination());
																	ps.setDate(6, listBO.get(i).getJourneyDate());
																}
																
																public int getBatchSize() {
																	return listBO.size();
																}
															}
				);
		return result;
	}

}
