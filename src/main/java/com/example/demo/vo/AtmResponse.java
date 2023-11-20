package com.example.demo.vo;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;

public class AtmResponse {

//	private int code;

//	private String message;
	
	private Atm atm;
	
	private RtnCode rtnCode;

	public AtmResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AtmResponse(Atm atm, RtnCode rtnCode) {
		super();
		this.atm = atm;
		this.rtnCode = rtnCode;
	}

	public Atm getAtm() {
		return atm;
	}

	public void setAtm(Atm atm) {
		this.atm = atm;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}



	
	
}
