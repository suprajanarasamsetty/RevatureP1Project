package com.revature.spring.revshop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.revature.demo.FrstSpring.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
		
	}
	   @Bean
	   public PlatformTransactionManager hibernateTransactionManager(LocalSessionFactoryBean sessionFactory) {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory.getObject());
	        return transactionManager;
	    }
	
	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProps = new Properties();
		
		//dialect
		hibernateProps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		//show sql queries in logs
		hibernateProps.setProperty("hibernate.show_sql", "true");
		// auto update
		hibernateProps.setProperty("hibernate.hbm2ddl.auto", "update");
		//hibernateProps.setProperty("hibernate.cache.use_second_level_cache", "true");
		//hibernateProps.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		//connection pool
		return hibernateProps;
		
	}
	
	
	
	
	

}
