package com.cg.ecommerce.service;

import java.util.List;

import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.entity.ReviewRating;
import com.cg.ecommerce.exceptions.NoProductException;


public interface ProductsSearchService {

	public List<Product> getProducts(String searchStr)throws NoProductException;
	public Double getOverAllRating(int prodId);
}
