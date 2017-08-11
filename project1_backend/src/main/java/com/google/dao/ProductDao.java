package com.google.dao;

import java.util.List;
//import java.util.Locale.Category;

import com.google.model.Product;
import com.google.model.Category;

public interface ProductDao {
void saveProduct(Product product);
 List<Product> getAllProducts();
Product getProductById(int id);
void deleteProduct(Product product);
void editProduct(Product product);
List<Category> getAllCategories();
}
