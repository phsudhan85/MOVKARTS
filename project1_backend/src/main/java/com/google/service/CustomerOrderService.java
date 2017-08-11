package com.google.service;

import com.google.model.Cart;
/*import com.google.model.Customer;*/
import com.google.model.CustomerOrder;
/*import com.google.model.ShippingAddress;*/

public interface CustomerOrderService {
CustomerOrder createOrder(Cart cart);
}