package com.example.demo.entity;

public class Animal {

	// getter setter
	private String name = "Rrrrr";

	protected final int age = 5;

	public Animal() {
		// �bnew���ɭԷ|�ʧ@
		super();
//		System.out.println("Animal �غc��k");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(this.name + " �Y��");
	}

	public void sleep() {
		System.out.println(this.name + " �ΰ�");
	}
	
	public void aniAction(Animal animal) {
		animal.eat();
		
	}

}
