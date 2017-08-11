package com.google.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.dao.CustomerDao;
import com.google.model.Customer;
import com.google.model.User;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	public void registerCustomer(Customer customer)
	{
		customerDao.registerCustomer(customer);
	}
	public User validateUsername(String username)
	{
		return customerDao.validateUsername(username);
	}
	public Customer validateEmail(String email)
	{
		return customerDao.validateEmail(email);
	}
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByUsername(username);
	}
}
