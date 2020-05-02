package com.cg.ecommerce.web;

import java.util.List;

import com.cg.ecommerce.dto.EcomerceMessage;
import com.cg.ecommerce.util.EcommerceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.ecommerce.entity.Cart;
import com.cg.ecommerce.entity.ProductOrder;
import com.cg.ecommerce.exceptions.NoOrderException;
import com.cg.ecommerce.service.OrderService;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

	@Autowired
	 private OrderService orderService;
	
	@GetMapping("/viewOrder/{userId}")
	public List<ProductOrder> viewOrder(@PathVariable("userId") String userId) throws NoOrderException {
		return orderService.viewOrder(userId);
	}
	
	@GetMapping("/viewProductsInOrder/{orderId}")
	public List<Cart> viewProductsInOrder(@PathVariable("orderId") String orderId) {
		return orderService.viewProductsInOrder(orderId);
	}

	@PutMapping("/cancelOrder/{orderid}")
	public EcomerceMessage cancelOrder(@PathVariable("orderid") String orderId) throws NoOrderException {
		orderService.cancelOrder(orderId);
		return new EcomerceMessage(EcommerceConstants.ORDER_CANCELLED);
	}

}
