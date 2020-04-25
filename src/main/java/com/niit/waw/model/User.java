package com.niit.waw.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalstring  = password;
		String encodedString = encoder.encodeToString(normalstring.getBytes(StandardCharsets.UTF_8));
		this.password = encodedString;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}
