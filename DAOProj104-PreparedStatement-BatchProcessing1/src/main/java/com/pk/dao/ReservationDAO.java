package com.pk.dao;

import java.util.List;

import com.pk.bo.PassengerBO;

public interface ReservationDAO {

	public int[] insertPassengersData(List<PassengerBO> listBO) throws Exception;
}
