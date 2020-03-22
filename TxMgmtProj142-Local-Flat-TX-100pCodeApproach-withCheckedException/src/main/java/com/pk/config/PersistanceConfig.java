package com.pk.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.pk.dao")
public class PersistanceConfig {

	@Bean("hkcpDS")
	public DataSource getDS() {
		HikariDataSource hkds = null;
		hkds = new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkds.setUsername("scott");
		hkds.setPassword("tiger");
		return hkds;
	}
	
	@Bean("templet")
	public JdbcTemplate getJT() {
		return new JdbcTemplate(getDS());
	}
}
