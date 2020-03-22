package com.pk.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.pk.entity.EmployeeEntity;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistanceConfig {
	
	@Autowired
	private HikariDataSource hkDS;

	@Bean(name="sesFact")
	public  LocalSessionFactoryBean getlocalSessionFactoryBean() {
		LocalSessionFactoryBean sesFactBean = new LocalSessionFactoryBean();
		Properties props = null;
		
		sesFactBean.setDataSource(hkDS);
		sesFactBean.setAnnotatedClasses(EmployeeEntity.class);
		
		props = new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect" );
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		sesFactBean.setHibernateProperties(props);
		
		return sesFactBean;
	}
	
	@Bean(name = "sesFact")
	public SessionFactory getSesFactory() {
		return getlocalSessionFactoryBean().getObject();
	}
	
	@Bean(name = "ht")
	public HibernateTemplate getHBTemplet() {
		return new HibernateTemplate(getlocalSessionFactoryBean().getObject() );
	}
}
