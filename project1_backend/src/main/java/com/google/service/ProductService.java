package com.google.service;

import java.util.List;
//import java.util.Locale.Category;

import com.google.model.Category;
import com.google.model.Product;

public interface ProductService {
void saveProduct (Product product);
 List<Product> getAllProducts();
Product getProductById(int id);
void deleteProduct(int id);
void updateProduct(Product product);
List<Category> getAllCategories();
}
