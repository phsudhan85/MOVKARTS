package com.google.configuration;


//import java.util.Locale.Category;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.model.Authorities;
import com.google.model.BillingAddress;
import com.google.model.Cart;
import com.google.model.CartItem;
import com.google.model.Category;
import com.google.model.Customer;
import com.google.model.CustomerOrder;
import com.google.model.Product;
import com.google.model.ShippingAddress;
import com.google.model.User;
//import com.google.model.Product;


@Configuration
@EnableTransactionManagement
public class DBConfiguration {
//bean id=""class="">
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("sa");
	    return dataSource;
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf=
				new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty(
				"hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[]=new Class[]{Product.class,Category.class,Customer.class,Cart.class,Authorities.class,BillingAddress.class,ShippingAddress.class,User.class,CartItem.class,CustomerOrder.class};
	    return lsf.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
	}
	