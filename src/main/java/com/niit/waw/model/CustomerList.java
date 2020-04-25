package com.niit.waw.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class CustomerList {
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Id
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="email_id")
	private String email;

	public CustomerList(String firstName, String lastName, String customerId, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.email = email;
	}

	public CustomerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerList [firstName=" + firstName + ", lastName=" + lastName + ", customerId=" + customerId
				+ ", email=" + email + "]";
	}
}

