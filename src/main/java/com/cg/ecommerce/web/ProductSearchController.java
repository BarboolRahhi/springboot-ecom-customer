package com.cg.ecommerce.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecommerce.dto.RatingMessage;
import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.entity.ReviewRating;
import com.cg.ecommerce.exceptions.NoProductException;
import com.cg.ecommerce.service.ProductsSearchService;

@RestController
public class ProductSearchController {

	@Autowired
	private ProductsSearchService service;
	
	@CrossOrigin
	@GetMapping("/search/{searchStr}")
	public List<Product> dispalysarchFormPage(@PathVariable("searchStr") String searchStr) throws NoProductException {
		return service.getProducts(searchStr);
	}
	
	@CrossOrigin
	@GetMapping("/OAR/{prodId}")
	public RatingMessage dispalyOverAllRatingFormPage(@PathVariable("prodId") int prodId ){
		double rating =  service.getOverAllRating( prodId);
		RatingMessage msg =  new RatingMessage(rating);
		return msg;
	}
	
	
}
