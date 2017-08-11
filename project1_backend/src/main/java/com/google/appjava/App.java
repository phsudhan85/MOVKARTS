package com.google.appjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.configuration.DBConfiguration;
import com.google.dao.ProductDaoImpl;
/*import com.google.model.Product;*/
import com.google.service.ProductService;
import com.google.service.ProductServiceImpl;

public class App {
	
	    public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" ); 
	     
	        ApplicationContext context=new AnnotationConfigApplicationContext(DBConfiguration.class,ProductDaoImpl.class,ProductServiceImpl.class);
	     // ProductService productService=(ProductService)context.getBean("productServiceImpl");
	      
	     // Product product=new Product();
	    //product.setId();
	     // product.setProductName("Pencil");
	     // product.setPrice(200);
	      //product.setQuantity(20);
	      //product.setDescription("desc about pencil");
	     // productService.saveProduct(product);
			
	    }
}
