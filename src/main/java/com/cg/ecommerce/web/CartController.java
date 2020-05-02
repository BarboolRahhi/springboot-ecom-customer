package com.cg.ecommerce.web;

import java.util.List;

import com.cg.ecommerce.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.ecommerce.dto.EcomerceMessage;
import com.cg.ecommerce.entity.Cart;
import com.cg.ecommerce.entity.ProductOrder;
import com.cg.ecommerce.exceptions.NoCartException;
import com.cg.ecommerce.exceptions.NoProductException;
import com.cg.ecommerce.service.CartService;
import com.cg.ecommerce.util.EcommerceConstants;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	CartService service;

	@CrossOrigin
	@PostMapping(path ="/addCart/{productid}/{userid}")
	public EcomerceMessage addToCart(@PathVariable("productid") int productId, @PathVariable("userid")String userId) {
		service.addCart(productId, userId);
		return new EcomerceMessage(EcommerceConstants.CART_ADDED);
	}

	@CrossOrigin
	@GetMapping(path = "viewCart/{userid}")
	public List<Cart> viewCart(@PathVariable("userid") String userID) throws NoCartException {
		return service.viewCart(userID);
	}

	@CrossOrigin
	@DeleteMapping(path ="delete/{cartid}")
	public EcomerceMessage deleteByCart(@PathVariable("cartid") int cartID) throws NoCartException {
		service.removeCart(cartID);
		return new EcomerceMessage(EcommerceConstants.CART_REMOVED);
	}

	@CrossOrigin
	@PostMapping(path ="addOrder/{userid}")
	public EcomerceMessage addOrder(@PathVariable("userid") String userId, @RequestBody Address address) throws NoCartException, NoProductException {
		service.addOrder(userId, address);
		return new EcomerceMessage(EcommerceConstants.ORDER_PLACED);
	}
}
