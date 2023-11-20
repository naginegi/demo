package com.example.demo.entity;

public class A1 {
	// 聚合，沒有使用extends
	// new C() 給C預設值，以防一開始get時報錯
	private C c = new C();
	public C getC() {
		return c;
	}
	public void setC(C c) {
		this.c = c;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	private String city;
//	
//	private String state;
//	
//	private String country;

	private String address;
}
