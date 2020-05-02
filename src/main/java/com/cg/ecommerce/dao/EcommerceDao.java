package com.cg.ecommerce.dao;

import java.util.List;

import com.cg.ecommerce.entity.Cart;
import com.cg.ecommerce.entity.Category;
import com.cg.ecommerce.entity.Product;
import com.cg.ecommerce.entity.ProductOrder;
import com.cg.ecommerce.entity.ProductSpecification;
import com.cg.ecommerce.entity.ReviewRating;
import com.cg.ecommerce.entity.UserEntity;

public interface EcommerceDao {

	public UserEntity getUser(String userID);
	
	public List<Category> getCategories();

	public List<Product> getProducts(int catId);
	public List<Product> getProducts(String searchStr);
	public Product getProduct(int productId);
	public boolean editProduct(Product prod);
	
	public List<ProductSpecification> getProductSpecifications(int productId);
	
	public List<ReviewRating> getProductReviews(int proId);
	public boolean addReviewRating(ReviewRating reviewRating);


	public boolean addCart(Cart cart);
	public boolean editCart(Cart cart);
	public Cart viewCart(long cartID);
	public boolean removeCart(Cart cart);
	public boolean removeCart(int orderId);
	
	public List<Cart> viewProductsInOrder(String orderId);
	public List<Cart> viewProductsInCart(String userId);
	
	public boolean addOrder(ProductOrder order);
	public boolean editOrder(ProductOrder order);
	public List<ProductOrder> viewOrderByUser(String userId);
	public ProductOrder viewProductOrder(String orderID);
	
	public boolean cancelOrder(ProductOrder order);
	public ProductOrder viewOrder(String orderId);
	public Long countRowsInOrder(String userId);

}
