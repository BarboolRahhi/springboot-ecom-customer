package com.cg.ecommerce.service;

import java.util.List;

import com.cg.ecommerce.entity.Cart;
import com.cg.ecommerce.entity.ProductOrder;
import com.cg.ecommerce.exceptions.NoCartException;
import com.cg.ecommerce.exceptions.NoOrderException;

public interface OrderService {
	public List<ProductOrder> viewOrder(String Contact)throws NoOrderException;
	public List<Cart> viewCart(String userId)throws NoCartException;
	public boolean cancelOrder(String orderId)throws NoOrderException;
    public List<Cart> viewProductsInOrder(String orderID);


}
