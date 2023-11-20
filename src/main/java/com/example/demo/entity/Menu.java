package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//��Ʈw�_��  1.�ظ�ƪ�(�b��Ʈw) 2.��Entity class (�o��) 3.��DAO interface (�b.repository)

@Entity // �U��
@Table(name = "menu") // �s�����Ʈw��"menu"
public class Menu {

	@Id // �{�w�o�OPK �ѧO���Ӹ�Ʈw���F��
	@Column(name = "name") // �o�O��Ʈw��"name"
	private String name; // �o�Ojava��"name"

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
