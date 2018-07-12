package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Category;
import com.niit.model.Product;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{

	@Bean
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/swagata");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("Data Source Object Created");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		sessionFactoryBuilder.addProperties(properties);
		
		sessionFactoryBuilder.addAnnotatedClass(Category.class);
		sessionFactoryBuilder.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		
		System.out.println("SessionFactory Object Created");
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
