package com.pk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.constraints.LoanTypeConstraints;
import com.pk.dto.CustomerLoanDetails;
import com.pk.service.BankLoanService;

public class BeforeAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankLoanService proxy = null;
		CustomerLoanDetails details = null;
		int loanId = 0;
		//create IOC Container
		ctx = new ClassPathXmlApplicationContext("com/pk/cfgs/applicationContext.xml");
		proxy = ctx.getBean("proxy", BankLoanService.class);
		//set Value 
		details = getLoanDetails();
		try {
			loanId = proxy.generateLoanId(details);
			System.out.println(proxy.approveLoan(loanId, details));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static CustomerLoanDetails getLoanDetails() {
		CustomerLoanDetails loanDetails = new CustomerLoanDetails();
		loanDetails.setClerkName("Ram Babu");
		loanDetails.setManagerName("Naresh");
		loanDetails.setCustomerName("Pankaj");
		loanDetails.setAdaharNo(123456781234L);
		loanDetails.setLoanAmt(100000);
		loanDetails.setLoanPurpose(LoanTypeConstraints.Loan_AGRICULTURE);
		return loanDetails;
	}

}
