package com.pk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.pk.bo.CustomerBO;

@Repository("custDAO")
public class BankCustomerDAOImpl implements BankCustomerDAO {
	public static final String GET_CUSTOMER_DETAILS ="SELECT CUSTID,CUSTNAME,CUSTADDS,BALANCE FROM BANK_CUSTOMER WHERE  CUSTID = :no";
	public static final String GET_CUSTOMERS_DETAILS_BY_BALANCE_RANGE ="SELECT CUSTID,CUSTNAME,CUSTADDS,BALANCE FROM BANK_CUSTOMER WHERE  BALANCE>=? AND BALANCE<=?";
	
	private CustomerSelecter selector;
	private customerListSelector listSelector;
	
	@Autowired
	public BankCustomerDAOImpl(DataSource ds) {
		selector = new CustomerSelecter(ds,GET_CUSTOMER_DETAILS);
		listSelector = new customerListSelector(ds, GET_CUSTOMERS_DETAILS_BY_BALANCE_RANGE);
	}

	public CustomerBO getEmpDetailsById(int id) {
		
		return selector.findObject(id);
	}
	
	private class CustomerSelecter extends MappingSqlQuery<CustomerBO>{

		public CustomerSelecter(DataSource ds,String query) {
			
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}
		
		@Override
		public CustomerBO  mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomerBO custBO = null;
			custBO = new CustomerBO();
			custBO.setCustID(rs.getInt(1));
			custBO.setCustName(rs.getString(2));
			custBO.setCustAddrs(rs.getString(3));
			custBO.setBalance(rs.getFloat(4));
			return custBO;
		}
		
	}

	public List<CustomerBO> getCustomersDetailsByBalanceRange(float minBal, float maxBal) {
		return listSelector.execute(minBal, maxBal);
	}
	
	
	
	
	
	private class customerListSelector extends MappingSqlQuery<CustomerBO>{
		
		public customerListSelector(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.compile();
		}

		@Override
		public CustomerBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankCustomerDAOImpl.customerListSelector.mapRow()");
			CustomerBO custBO = null;
			custBO = new CustomerBO();
			custBO.setCustID(rs.getInt(1));
			custBO.setCustName(rs.getString(2));
			custBO.setCustAddrs(rs.getString(3));
			custBO.setBalance(rs.getFloat(4));
			System.out.println(custBO);
			return custBO;
			//no need to take List<CustomerBO> bcz here resultSet created  then 
			//it will create another resultSet with one rcord obj and call the mapRow(-) method 
			//with new resultSet obj as argument having 1 record and the index then every time it will create a new ResultSet obj and call mapRow(-) method
		}
		
	}

}
