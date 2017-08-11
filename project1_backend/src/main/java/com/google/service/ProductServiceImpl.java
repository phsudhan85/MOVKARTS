package com.google.service;

import java.util.List;
//import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.dao.ProductDao;
import com.google.model.Product;
import com.google.model.Category;
@Service//productServiceImpl=new ProductServiceImpl()
@Transactional
public class ProductServiceImpl implements ProductService {
	public ProductServiceImpl(){
		System.out.println("ProductServiceImpl obj is created");
	}
	@Autowired
	private ProductDao productDao;
	public void saveProduct(Product product){
		productDao.saveProduct(product);
	}
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	public List<Category> getAllCategories() {
		return productDao.getAllCategories();
	}
	public Product getProductById(int id){
		return productDao.getProductById(id);
	}
	public void deleteProduct(int id){
		Product product=getProductById(id);
		productDao.deleteProduct(product);
	}
	public void updateProduct(Product product){
		productDao.editProduct(product);;
	}
}
