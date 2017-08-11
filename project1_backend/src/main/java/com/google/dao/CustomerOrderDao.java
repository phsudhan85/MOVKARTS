package com.google.dao;

import com.google.model.Cart;
/*import com.google.model.Customer; */
import com.google.model.CustomerOrder;
/*import com.google.model.ShippingAddress;*/

public interface CustomerOrderDao {
CustomerOrder createOrder(Cart cart);

}