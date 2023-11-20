package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//資料庫起手  1.建資料表(在資料庫) 2.建Entity class (這裡) 3.建DAO interface (在.repository)

@Entity // 託管
@Table(name = "menu") // 連結到資料庫的"menu"
public class Menu {

	@Id // 認定這是PK 識別哪個資料庫的東西
	@Column(name = "name") // 這是資料庫的"name"
	private String name; // 這是java的"name"

	@Column(name = "price")
	private int price;

	public Menu() {
		super();
	}

	public Menu(String name, int prive) {
		super();
		this.name = name;
		this.price = prive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrive() {
		return price;
	}

	public void setPrive(int prive) {
		this.price = prive;
	}

}
