package com.google.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.service.ProductService;


@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	HomeController(){
		System.out.println("CREATING INSTANCE OF HomeController");
	}
@RequestMapping("/home")
public String homepage(HttpSession session){
	session.setAttribute("categories",productService.getAllCategories());
	return "home";
}
@RequestMapping("/aboutus")
public String aboutUs(){
	return "aboutus";
}
@RequestMapping("/login")
public String login(){
	return "login";
}
}