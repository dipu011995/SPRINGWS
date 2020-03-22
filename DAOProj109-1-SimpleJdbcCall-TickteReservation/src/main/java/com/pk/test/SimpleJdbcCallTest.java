package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.TicketReservationMgmtService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		TicketReservationMgmtService service = null;
		//create container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("reservationService", TicketReservationMgmtService.class);
		
		//invoke method
		System.out.println("101 passenger details"+service.fetchPassengerDetails(101));

	}

}
;