package com.pk.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.pk.constraints.LoanTypeConstraints;
import com.pk.dto.CustomerLoanDetails;

public class BankLoanServiceImpl implements BankLoanService {

	public int generateLoanId(CustomerLoanDetails details) throws Exception {

		if((details.getLoanAmt()<=200000) && ((details.getLoanPurpose().equalsIgnoreCase(LoanTypeConstraints.Loan_AGRICULTURE)) 
																				|| (details.getLoanPurpose().equalsIgnoreCase(LoanTypeConstraints.Loan_PERSONAL))
																				|| (details.getLoanPurpose().equalsIgnoreCase(LoanTypeConstraints.Loan_VEHICLE)))){
		
		   /* int adhar = getLast4digitOfAdhar(details.getAdaharNo());
			int generatedNo = new Random().nextInt(1000);	
			int finalNumber = Integer.parseInt(adhar+generatedNo);*/

			return  Integer.parseInt(getLast4digitOfAdhar(details.getAdaharNo())+""+new Random().nextInt(100));
		}
		else
			throw new IllegalAccessException("Invalid Loan Details");
	}
	
	private int getLast4digitOfAdhar(long adharNo) {	
		return Integer.parseInt(Long.toString(adharNo).substring(8, 12));
	}

	public String approveLoan(int loanId, CustomerLoanDetails details) {
		//		int month = Calendar.getInstance().MONTH;
		//				System.out.println(month);
				int month =new Date().getMonth();
	//	System.out.println(details.getLoanPurpose()+"   "+month);
		if((details.getLoanPurpose().equalsIgnoreCase(LoanTypeConstraints.Loan_AGRICULTURE)) && (month>=5 && month<=12) )
			return "Loan Approved for "+ loanId+" of name::"+ details.getCustomerName()+" for the purpose of "+details.getLoanPurpose()+" by clerk "+details.getClerkName()+ "and manager "+details.getManagerName()+" On Date:: "+new Date();
		else if((details.getLoanPurpose().equalsIgnoreCase(LoanTypeConstraints.Loan_VEHICLE)) && (month>=0 && month<=5) )
			return "Loan Approved for "+ loanId+" of name::"+ details.getCustomerName()+" for the purpose of "+details.getLoanPurpose()+" by clerk "+details.getClerkName()+ "and manager "+details.getManagerName()+" On Date:: "+new Date();
		else if((details.getLoanPurpose().equalsIgnoreCase(LoanTypeConstraints.Loan_PERSONAL)))
			return "Loan Approved for "+ loanId+" of name::"+ details.getCustomerName()+" for the purpose of "+details.getLoanPurpose()+" by clerk "+details.getClerkName()+ "and manager "+details.getManagerName()+" On Date:: "+new Date();
		else
			return "Loan not Approved";
	}

}
