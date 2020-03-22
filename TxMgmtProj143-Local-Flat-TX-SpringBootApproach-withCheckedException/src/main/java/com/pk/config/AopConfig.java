package com.pk.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.pk.service.BankService;

@Configuration
public class AopConfig {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private BankService service;
	
	@Bean("dsTxMgr")
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager dtm =null;
		dtm = new DataSourceTransactionManager();
		dtm.setDataSource(ds);
		return dtm;
	}
	
	@Bean("tpfb")
	public TransactionProxyFactoryBean getTxPfb() {
		TransactionProxyFactoryBean tfb=null;
		Properties props = null;
		tfb = new TransactionProxyFactoryBean();
		tfb.setTarget(service);
		tfb.setTransactionManager(getTransactionManager());
		props = new Properties();
		props.put("transferMoney", "PROPAGATION_REQUIRED,-java.lang.IllegalAccessException");
		tfb.setTransactionAttributes(props);
		return tfb;
	}
	
	
}
