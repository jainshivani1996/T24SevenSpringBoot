package com.niit.waw.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;*/

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Id
	@Column(name="customer_id")
	private String customerId;

	@Column(name="password")
	private String password;

	@Column(name="dob")
	private String dob;

	@Column(name="email_id")
	private String email;

	@Column(name="phone_no")
	private String phoneNo;

	@Column(name="adhar_no")
	private String adharNo;

	private String street;
	private String city;

	@Column(name="pin_code")
	private int pinCode;

	@OneToOne(mappedBy="customer")
	private Account account;

	public Customer() {

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalstring  = password;
		String encodedString = encoder.encodeToString(normalstring.getBytes(StandardCharsets.UTF_8));
		this.password = encodedString;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob2) {
		this.dob = dob2;
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

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int postalCode) {
		this.pinCode = postalCode;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer(String firstName, String lastName, String customerId, String password, String dob, String email,
			String phoneNo, String adharNo, String street, String city, int pinCode, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.password = password;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.adharNo = adharNo;
		this.street = street;
		this.city = city;
		this.pinCode = pinCode;
		this.account = account;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerId=" + customerId
				+ ", password=" + password + ", dob=" + dob + ", email=" + email + ", phoneNo=" + phoneNo + ", adharNo="
				+ adharNo + ", street=" + street + ", city=" + city + ", pinCode=" + pinCode + ", account=" + account
				+ "]";
	}

}


