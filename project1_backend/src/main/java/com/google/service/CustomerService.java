package com.google.service;

import com.google.model.Customer;
import com.google.model.User;

public interface CustomerService {
void registerCustomer(Customer customer);
User validateUsername(String username);
Customer validateEmail(String email);
Customer getCustomerByUsername(String username);
}
