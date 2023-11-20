package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest
public class AtmServiceTest {

	@Autowired
	private AtmService atmservice;

	@Test
	public void addInfoTest() {
		AtmResponse res = atmservice.addInfo(null, null);
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());
		res = atmservice.addInfo("AAA", "123");
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());
		res = atmservice.addInfo("AAA", "456");
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());

	}

	@Test
	public void addInfoTest1() {
		AtmResponse res = atmservice.addInfo("CCC", "123");
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());
		System.out.println(res.getAtm().getAccount() + ":" + res.getAtm().getPwd());
	}

	@Test
	public void findAccTest1() {
		AtmResponse res = atmservice.getBalanceByAccount("CCC", "123");
		System.out.println(res.getAtm().getAccount() + ":" + res.getAtm().getbalance());
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());
	}

	@Test
	public void depositTest1() {
		AtmResponse res = atmservice.deposit("CCC", "123", 100);
		if (res.getRtnCode().getCode() == 200) {
			System.out.println(res.getAtm().getAccount() + ":" + res.getAtm().getbalance());
		}
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());
	}

	@Test
	public void withdrawTest1() {
		AtmResponse res = atmservice.withdraw("CCC", "123", 30);
		if (res.getRtnCode().getCode() == 200) {
			System.out.println(res.getAtm().getAccount() + ":" + res.getAtm().getbalance());
		}
		System.out.println(res.getRtnCode().getCode() + ":" + res.getRtnCode().getMessage());
	}
}
