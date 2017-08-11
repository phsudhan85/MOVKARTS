package com.google.dao;

import com.google.model.Cart;
import com.google.model.CartItem;

public interface CartItemDao {
void addCartItem(CartItem cartItem);
void removeCartItem(int cartItemId);
public void removeAllCartItem(int cartId);
public Cart getCart(int cartId);

}
