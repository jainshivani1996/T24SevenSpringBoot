package com.niit.waw.model;

import java.util.Date;

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

	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="account_no")
	private Long accountNo;
	@Column(name="trans_date")
	private Date transDate;

	public CustomerList(String firstName, String lastName, String customerId, String email, String phoneNo,
			Long accountNo,Date transDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.email = email;
		this.phoneNo = phoneNo;
		this.accountNo = accountNo;
		this.transDate=transDate;

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	



	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	@Override
	public String toString() {
		return "CustomerList [firstName=" + firstName + ", lastName=" + lastName + ", customerId=" + customerId
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", accountNo=" + accountNo + "]";
	}

	}

