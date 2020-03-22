package com.pk.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pk.dto.PolicyDTO;
import com.pk.service.PolicyMgmtService;
import com.pk.service.PolicyMgmtServiceImpl;

public class SimpleJdbcTempletTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		PolicyMgmtService service = null;
		Scanner sc = null;
		
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		service = ctx.getBean("empService", PolicyMgmtServiceImpl.class);	
		sc = new Scanner(System.in);
		PolicyDTO dto = null;
		try {
			dto = new PolicyDTO();
			System.out.println("Enter PolicyName::");
			dto.setPolicyName(sc.nextLine());
			System.out.println("Enter Policy Type");
			dto.setPolicyType(sc.nextLine());
			System.out.println("Enter company");
			dto.setCompany(sc.next());
			System.out.println("Enter policy term::");
			dto.setTerm(sc.nextInt());
			System.out.println("Enter Monthly Instalment");
			dto.setMonthlyInstalment(sc.nextFloat());
			System.out.println(" Employee Details by Desg:::"+ service.applyPolicy(dto));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
			
	}

}
