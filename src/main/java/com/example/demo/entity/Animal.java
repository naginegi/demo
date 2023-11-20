package com.example.demo.entity;

public class Animal {

	// getter setter
	private String name = "Rrrrr";

	protected final int age = 5;

	public Animal() {
		// 在new的時候會動作
		super();
//		System.out.println("Animal 建構方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println(this.name + " 吃啦");
	}

	public void sleep() {
		System.out.println(this.name + " 睡啦");
	}
	
	public void aniAction(Animal animal) {
		animal.eat();
		
	}

}
