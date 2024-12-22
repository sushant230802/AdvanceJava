package com.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="categoryId")
	int cid;
	
	@Column(name="categoryName")
	String categoryName;
	
	@Column(name="categoryDescription")
	String categoryDescription;
	
	@Column(name="categoryImageUrl")
	String categoryUrl;

	public Category() {
		
	}
	public Category(int cid, String categoryName, String categoryDescription, String categoryUrl) {
		super();
		this.cid = cid;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryUrl = categoryUrl;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryUrl() {
		return categoryUrl;
	}

	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}
	
	
}
