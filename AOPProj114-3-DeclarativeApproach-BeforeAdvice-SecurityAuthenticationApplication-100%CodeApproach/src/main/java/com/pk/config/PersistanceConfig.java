package com.pk.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.pk.dao")
public class PersistanceConfig {

	/*@Bean
	public DataSource getDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		return ds;
	}*/
	
	@Bean("npjc")
	public NamedParameterJdbcTemplate getTemplet() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		return new NamedParameterJdbcTemplate(ds);
	
	}
}
