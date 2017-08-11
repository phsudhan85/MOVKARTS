package com.google.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.dao.CustomerOrderDao;
import com.google.model.Cart;
import com.google.model.Customer;
import com.google.model.CustomerOrder;
import com.google.model.ShippingAddress;
@Service
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService{
	@Autowired
private CustomerOrderDao customerOrderDao;
	public CustomerOrder createOrder(Cart cart) {
		return customerOrderDao.createOrder(cart);
	}
	
}