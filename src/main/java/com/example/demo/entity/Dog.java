package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

/*
類別與物件
JAVA所有東西都能稱為物件
物件的特性稱 屬性 --> 相對於 人的身高年齡等
物件的行為稱 方法 --> 相對於 人的走路騎車等
*/

public class Dog implements RunService{

	// 只有在類別底下的屬性給權限(private)
	// 方法裡的變數不能加權限
	// 各個屬性間加enter格開，方便閱讀
	// 對屬性 set get
	// public 存取的權限最大，可在所有地方存取
	// private 存取的權限最小，只能在所在的地方
	
	private String name = "dog";

	private String color;

	private int age;
	
	
	//預設建構方法
	//空白地方右鍵-->source-->Generate Constructor from superclass
	public Dog() {
		super();//用於繼承
	}
	
	//帶有參數的建構方法，必綁定上方"預設建構方法"
	//空白地方右鍵-->source-->Generate Constructor using Fields
	public Dog(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	//公開方法
	//空白地方右鍵-->source-->Generate Getters and Setters
	//set : void無回傳東西。get ： 會回傳那個類別的東西 
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;//加this的原因：區分哪個是哪個name
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public void setAttributes() {

	}
	
	public static void setAttributes2() {
		
	}

	@Override
	public void run() {
		System.out.println(" 狗 跑");
		
	}
}
