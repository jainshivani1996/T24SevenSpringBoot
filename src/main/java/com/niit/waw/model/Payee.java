package com.niit.waw.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="beneficiary")
public class Payee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="beneficiary_id")
	private int beneficiaryId;
	
	@Column(name="payee_account")
	private long payeeAccount;
	@Column(name="payee_ifsc")
	private String payeeIfsc;
	@Column(name="payee_name")
	private String nickName;
	@Column(name="account_no")
	private long accountNo;
	
	//@JoinColumn(name="account_no")
//	private Account account;
	
	public Payee(){
		
	}

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(long payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public String getPayeeIfsc() {
		return payeeIfsc;
	}

	public void setPayeeIfsc(String payeeIfsc) {
		this.payeeIfsc = payeeIfsc;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}


	

	
}
