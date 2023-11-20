package com.example.demo.entity;

public class Bird extends Animal {
				  // 記得 extends 父類別 *很重要
	/*
	//跟 父類別(Animal) 重複的屬性方法
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 */

	public Bird() {
		//在new的時候會動作
		super();
//		System.out.println("Bird 建構方法");
		//子從父拿
//		int a = super.age+5;
//		System.out.println(this.age);
//		System.out.println(a);
	}
	
	// 複寫覆蓋，重新定義
	// 父子類別 具同名方法+參數個數，子類別重新定義{ }內方法
	// java 9 之後可不加Override 但習慣會加，表示父類別有相同方法
	

	@Override 
	public void eat() {
		System.out.println(super.getName()+" 在吃啦喝啦");
	}

	@Override 
	public void sleep() {
		System.out.println(super.getName()+" 在睡啦哭阿");
	}
	
	public void fly() {
		//子層方法取父層屬性
		System.out.println(super.getName()+" 在flying");
	}
}
