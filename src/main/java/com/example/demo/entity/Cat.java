package com.example.demo.entity;

public class Cat extends Animal {
				// 記得 extends 父類別 *很重要
	
	/*
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override // 習慣加
	public void eat() {
		System.out.println("吃啦");
	}
	 */
	
	@Override // 習慣加
	public void sleep() {
		System.out.println("睡啦");
	}
	
	public void meow() {
		System.out.println("meow meow meow");
	}
	
}
