package com.google.dao;

import java.util.List;
//import java.util.Locale.Category;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.google.model.Product;
import com.google.model.Category;
@Repository
public class ProductDaoImpl implements ProductDao {
	
public ProductDaoImpl(){
System.out.println("ProductDaoImpl Object is created");
}
@Autowired
private SessionFactory sessionFactory;
public void saveProduct(Product product){
	Session session=sessionFactory.getCurrentSession();
	session.save(product);
}
public List<Product> getAllProducts(){
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Product");
			List<Product> products=query.list();
			return products;
}
public List<Category> getAllCategories(){
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Category");
			List<Category> categories=query.list();
			return categories;
}
public Product getProductById(int id){
	Session session=sessionFactory.getCurrentSession();
	Product product=(Product)session.get(Product.class, id);
	return product;
}
public void deleteProduct(Product product){
	Session session=sessionFactory.getCurrentSession();
	session.delete(product);
	}
public void editProduct(Product product){
	Session session=sessionFactory.getCurrentSession();
	session.update(product);
}
}
