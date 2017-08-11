package com.google.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.google.model.Customer;
import com.google.model.User;
import com.google.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;

@Controller
public class CustomerController {
@Autowired
private CustomerService customerService;

@RequestMapping("/all/registrationform")
public String getRegistrationForm(Model model){
	model.addAttribute("customer",new Customer());
	return "registrationform";
}

@RequestMapping("/all/savecustomer")
public String registerCustomer(@Valid @ModelAttribute Customer customer,BindingResult result,Model model)
{
	if(result.hasErrors())
	{
		return "registrationform";
	}
	User user=customerService.validateUsername(customer.getUser() .getUsername());
	if(user!=null){
		model.addAttribute("duplicateUsername","Username already exists");
		return "registrationform";
			}
	Customer duplicateCustomer= customerService.validateEmail(customer.getEmail());
	if(duplicateCustomer!=null){
		model.addAttribute("duplicateEmail", "Email address already exists");
		return "registrationform";
	}
	customerService.registerCustomer(customer);
	return "home";
}
}
