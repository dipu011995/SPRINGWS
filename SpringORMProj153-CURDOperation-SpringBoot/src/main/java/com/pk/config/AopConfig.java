package com.pk.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
public class AopConfig {

	@Autowired
	private SessionFactory sesFact;
	
	@Bean(name = "hbTxMgmr")
	public HibernateTransactionManager getTxMgmr() {
		return new HibernateTransactionManager(sesFact);
	}
}
