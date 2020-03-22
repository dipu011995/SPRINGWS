package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pk.service.BankService;

@SpringBootApplication
public class TxmgmTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService service = null;
		
		ctx = SpringApplication.run(TxmgmTest.class, args);
		service = ctx.getBean("bankService", BankService.class);
		//invoke method
		try {
			System.out.println(service.transferMoney(1001, 1002, 5000));
		}
		catch (IllegalAccessException iae) {
			iae.printStackTrace();
		}
	}

}
