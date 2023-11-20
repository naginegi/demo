package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "atm")
public class Atm {
	
	@Id
	@Column(name = "account")
	private String account;
	
	@Column(name = "password")
	private String pwd;
	
	@Column(name = "balance")
	private int balance;

	public Atm() {
		super();
	}

	//創建時沒有balance
	public Atm(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}

	public Atm(String account, String password, int balance) {
		super();
		this.account = account;
		this.pwd = password;
		this.balance = balance;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String password) {
		this.pwd = password;
	}

	public int getbalance() {
		return balance;
	}

	public void setbalance(int balance) {
		this.balance = balance;
	}
	
	
}
