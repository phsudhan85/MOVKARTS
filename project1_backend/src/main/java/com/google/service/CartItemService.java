package com.google.service;

import com.google.model.Cart;
import com.google.model.CartItem;

public interface CartItemService {
void addCartItem(CartItem cartItem);
void removeCartItem(int cartItemId);
void removeAllCartItems(int cartId);
Cart getCart(int cartId);
}
