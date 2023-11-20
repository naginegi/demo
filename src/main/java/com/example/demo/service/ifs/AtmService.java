package com.example.demo.service.ifs;

import com.example.demo.vo.AtmResponse;

public interface AtmService {
	
	public AtmResponse addInfo(String account ,String pwd);
	
	public AtmResponse getBalanceByAccount(String account,String pwd);
	
	public AtmResponse updataPwd(String account,String oldpwd,String newpwd);
	
	public AtmResponse deposit(String account,String pwd,int balance);
	
	public AtmResponse withdraw(String account,String pwd,int balance);
	
}
