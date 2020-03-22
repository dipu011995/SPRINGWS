package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.pk.config.AopConfig;
import com.pk.service.BankService;

@SpringBootApplication
@Import(AopConfig.class)
public class TxmgmTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService service = null;
		
		ctx = SpringApplication.run(TxmgmTest.class, args);
		service = ctx.getBean("tpfb", BankService.class);
		//invoke method
		try {
			System.out.println(service.transferMoney(1001, 1002, 5000));
		}
		catch (IllegalAccessException iae) {
			iae.printStackTrace();
		}
	}

}
