package com.bankapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int acc_no;
	@Column(name="acc_name")
	String acc_name;
	@Column(name="balance")
	double balance;
	public Account(int acc_no, String acc_name, double balance) {
		super();
		this.acc_no = acc_no;
		this.acc_name = acc_name;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [acc_no=" + acc_no + ", acc_name=" + acc_name + ", balance=" + balance + "]";
	}
	
	
	
	
	
}
