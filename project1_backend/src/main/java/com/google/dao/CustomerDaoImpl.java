package com.google.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.model.Authorities;
import com.google.model.Cart;
import com.google.model.Customer;
import com.google.model.User;


@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer){
		User user=customer.getUser();
		user.setEnabled(true);
		String username=customer.getUser().getUsername();
		
		Authorities authorities=new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUsername(username);
		
		Session session=sessionFactory.getCurrentSession();
		session.save(authorities);
		
		Cart cart=new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		session.save(customer);
	}
	public User validateUsername(String username){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where username=?");
		query.setString(0, username);
		User user=(User)query.uniqueResult();
		return user;
	}
	public Customer validateEmail(String email){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Customer where email=?");
		query.setString(0, email);
		Customer customer=(Customer)query.uniqueResult();
		return customer;
}
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Customer where user.username=?");
		query.setString(0, username);
		Customer customer=(Customer)query.uniqueResult();
		return customer;
	}

}