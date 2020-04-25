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

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trans_id")
	private int transId;
	
	@Column(name="trans_date")
	private Date transDate;
	@Column(name="old_amount")
	private int oldAmount;
	@Column(name="new_amount")
	private int newAmount;
	@Column(name="account_no")
	private Long accountNo;
	
	//@JoinColumn(name="account_no")
//	private Account account;
	
	public Transaction(){
		
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public int getOldAmount() {
		return oldAmount;
	}

	public void setOldAmount(int oldAmount) {
		this.oldAmount = oldAmount;
	}

	public int getNewAmount() {
		return newAmount;
	}

	public void setNewAmount(int newAmount) {
		this.newAmount = newAmount;
	}

	

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", transDate=" + transDate + ", oldAmount=" + oldAmount
				+ ", newAmount=" + newAmount +  "]";
	}
	
}
