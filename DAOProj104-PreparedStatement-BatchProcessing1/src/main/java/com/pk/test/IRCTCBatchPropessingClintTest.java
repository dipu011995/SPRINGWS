package com.pk.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.dto.PassengerDTO;
import com.pk.service.IRCTCMgmtService;

public class IRCTCBatchPropessingClintTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IRCTCMgmtService service = null;
		Scanner sc = null;
		boolean proceed = true;
		List<PassengerDTO> listDTO = null;
		PassengerDTO dto = null;
		
		//create application context container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		//get Bean Method
		service = ctx.getBean("passengerService", IRCTCMgmtService.class);
		listDTO = new ArrayList<PassengerDTO>();
		sc = new Scanner(System.in);
		while(proceed) {	
			 dto = new PassengerDTO();
				//read passenger inputs
				System.out.println("Enter Passenger Name");
				dto.setPassengerName(sc.next());
				System.out.println("Enter Passenger Age");
				dto.setAge(sc.nextByte());
				System.out.println("Enter Passenger Gender");
				dto.setGender(sc.next());
				System.out.println("Enter Passenger Source");
				dto.setSource(sc.next());
				System.out.println("Enter Passenger Destination");
				dto.setDestination(sc.next());
				System.out.println("Enter Passenger Journey Date");
				dto.setJourneyDate(Date.valueOf(sc.next()));
				
				listDTO.add(dto);
				System.out.println("Do you want to Add more Passenger Y / N ? ");
				String check = sc.next();
				if(check.equalsIgnoreCase("Y"))
					proceed = true;
				else
					proceed = false;
		}
		try {
			//invoke method
			System.out.println("Result :::::"+service.reserveTicket(listDTO));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}