package com.secondHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="userName")
	String userName;
	
	@Column(name="password")
	String password;
	
	@Column(name="name")
	String name;
	
	@Column(name="email")
	String email;
	
	public User() {
		
	}
	
	public User(String userName, String password, String name, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
