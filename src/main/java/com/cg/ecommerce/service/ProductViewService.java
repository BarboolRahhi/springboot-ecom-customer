package com.cg.ecommerce.service;

import java.util.List;

import com.cg.ecommerce.entity.Category;
import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.entity.ProductSpecification;
import com.cg.ecommerce.entity.ReviewRating;
import com.cg.ecommerce.exceptions.NoProductException;
import com.cg.ecommerce.exceptions.NoReviewException;

public interface ProductViewService {
	
	List<Category> viewCategories();
	List<Product> viewProducts(int catId)throws NoProductException;
	List<ProductSpecification> viewProductSpecifications(int productId)throws NoProductException;
	List<ReviewRating> viewProductReviews(int proId)throws NoReviewException;
	Product viewProductById(Integer pid) throws NoProductException;
	boolean addReviewRating(ReviewRating reviewRating);

}
