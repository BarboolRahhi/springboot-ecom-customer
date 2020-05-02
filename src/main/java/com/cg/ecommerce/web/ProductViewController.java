package com.cg.ecommerce.web;

import java.util.List;

import com.cg.ecommerce.dto.EcomerceMessage;
import com.cg.ecommerce.util.EcommerceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.ecommerce.entity.Category;
import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.entity.ProductSpecification;
import com.cg.ecommerce.entity.ReviewRating;
import com.cg.ecommerce.exceptions.NoProductException;
import com.cg.ecommerce.exceptions.NoReviewException;
import com.cg.ecommerce.service.ProductViewService;

@RestController
public class ProductViewController {
	
	@Autowired
	private ProductViewService service;
	
	@CrossOrigin
	@GetMapping("/viewcat")
	public List<Category> getCategories(){
		return service.viewCategories();
	}

	@CrossOrigin
	@GetMapping("/viewprodbyid/{pid}")
	public Product getCategories(@PathVariable("pid") int pid) throws NoProductException {
		return service.viewProductById(pid);
	}
	
	@CrossOrigin
	@GetMapping("/viewprod/{catid}")
	public List<Product> getProducts(@PathVariable("catid") int cid) throws NoProductException{
		return service.viewProducts(cid);
	}
	
	@CrossOrigin
	@GetMapping("/viewprodspec/{prodid}")
	public List<ProductSpecification> getProductSpecifications(@PathVariable("prodid") int pid) throws NoProductException{
		return service.viewProductSpecifications(pid);
	}
	
	@CrossOrigin
	@GetMapping("/viewprodreview/{prodid}")
	public List<ReviewRating> getProductReviewRatings(@PathVariable("prodid") int pid) throws NoReviewException{
		return service.viewProductReviews(pid);
	}

	@CrossOrigin
	@PostMapping("/addReview")
	public EcomerceMessage addReview(@RequestBody ReviewRating review) {
		service.addReviewRating(review);
		return new EcomerceMessage(EcommerceConstants.REVIEW_ADDED);
	}

	
}
