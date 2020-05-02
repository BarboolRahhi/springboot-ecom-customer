package com.cg.ecommerce.service;

import java.util.List;

import com.cg.ecommerce.entity.Address;
import com.cg.ecommerce.entity.Cart;
import com.cg.ecommerce.entity.ProductOrder;
import com.cg.ecommerce.exceptions.NoCartException;
import com.cg.ecommerce.exceptions.NoProductException;

public interface CartService {

	public boolean addCart(int productId, String userId);
	public Cart viewCart(int cartID)throws NoCartException;
	public List<Cart> viewCart(String userId)throws NoCartException;
	public boolean removeCart(long cartId)throws NoCartException;
	
	public boolean addOrder(String userID, Address address)throws NoCartException, NoProductException;
	
	
}
