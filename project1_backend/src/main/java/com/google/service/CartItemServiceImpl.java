package com.google.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.dao.CartItemDao;
import com.google.model.Cart;
import com.google.model.CartItem;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
@Autowired
private CartItemDao cartItemDao;
public void addCartItem(CartItem cartItem){
	cartItemDao.addCartItem(cartItem);
}
public void removeCartItem(int cartItemId){
	cartItemDao.removeCartItem(cartItemId);
}
public void removeAllCartItems(int cartId){
	cartItemDao.removeAllCartItem(cartId);
}
public Cart getCart(int cartId) {
	// TODO Auto-generated method stub
	return cartItemDao.getCart(cartId);
}
}
