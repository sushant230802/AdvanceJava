//pojo class(plain old java object)

package com.cdac.cart;

public class CartItem {
	int categoryId;
	int productId;
	float productPrice;
	
	public CartItem() {
		
	}
	public CartItem(int categoryId, int productId, float productPrice) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
		this.productPrice = productPrice;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
}
