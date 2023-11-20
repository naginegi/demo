package com.example.demo;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {

	@Test
	public void classTest() {
		// 可產生多個，再去定義屬性值
		Dog dog = new Dog();
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();

		String name = dog.getName();
		String color = dog.getColor();
		System.out.println("dog-name  : " + name);
		System.out.println("dog-color : " + color);
		System.out.println("\n================\n");
		dog.setName("cat");
		dog.setColor("blue");
		name = dog.getName();
		color = dog.getColor();
		System.out.println("dog-name  : " + name);
		System.out.println("dog-color : " + color);
		System.out.println("\n================\n");
//		int age = dog.age;
//		System.out.println(age);
//		dog.age = 5;
//		System.out.println(dog.age);
	}

	@Test
	public void classTest1() {
		// 自定義方法，一次設定多種屬性值，但一般不會這樣做，有其他方法可用
		Dog dog = new Dog();
//		dog.setAttributes("bara", "green", 55);
		System.out.printf("name:%s,color:%s,age:%d", dog.getName(), dog.getColor(), dog.getAge());
	}

	@Test
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		// 驗證   如果條件沒達成(條件為false)，顯示字串"saving error"，並且停止程式
		Assert.isTrue(bank.getBalance() == 100, "saving error");
		bank.saving(500);//這個500叫做"實參"，代表實際傳入的參數
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 1500, "saving error");
		bank.withdraw(800);
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 700, "saving error");

		
	}
	
	
	@Test
	public void classTest3() {
		//印出檔案位置+檔案名稱+記憶體位置
		System.out.println(new TaipeiBank());
		Dog dog = new Dog();
		System.out.println(dog);
		System.out.println("===============");
		Dog dogg = new Dog();
		System.out.println(dogg);
		Dog doggg = dog;
		//dog跟doggg同個記憶體位置 dogg不同
		//== 僅用來比較記憶體位置及八種資料型態，還有布林值
		System.out.println(dog == dogg);//false
		System.out.println("==============");
		System.out.println(dog == doggg);//true
		
	}

	
	@Test
	public void classTest4() {
		//== 僅用來比較記憶體位置及八種資料型態(不管大小寫)
		System.out.println("==============");
		//比較數值，印出false
		int a = 5,b = 4;
		System.out.println("int：" + (a == b));
		System.out.println("==============");
		//印出true
		char a1 = 'z',b1 = 'z';
		System.out.println(a1 == b1);
		System.out.println("==============");
		//只要用new 就是一個新的記憶體空間，印出false;
		//不過在八種資料型態中沒有人會這樣寫
		//用new的 比較的就是記憶體位置
		Integer a2 = new Integer(10);
		Integer b2 = new Integer(10);
		System.out.println(a2 == b2);
		System.out.println("==============");
		//也可比較布林值
		boolean bool1 = true;
		boolean bool2 = true;
		Boolean bool3 = true;
		System.out.println(bool1 == bool2);//true
		System.out.println(bool1 == bool3);//true
		System.out.println("==============");
		//比較字串，印出true (?)，比較字串用equals，見StringTest
		String str1 = "123";
		String str2 = "123";
		System.out.println(str1 == str2);
		System.out.println("==============");
	}
	
	
	@Test
	public void classTest5() {
		//一般方法
		Dog dog = new Dog();
		dog.setAge(50);
		dog.setColor("red");
		dog.setName("EE");
		System.out.println("=============");
		//使用預設建構方法設值
		Dog dogg = new Dog("WW","AAA",5);
		System.out.println("=============");
	}
	
	
	@Test
	public void classTest6() {
		Dog dog = new Dog();
		dog.setAttributes();//一般方法呼叫，必須先把類別new出來
		Dog.setAttributes2();//static方法的呼叫，直接用類別名稱.static方法
		System.out.println("===========================");
		Math.random();
		Random ran = new Random();
		final int a = 5; //代表a不能再被更改，通常用於常量
		// a = 6; 會error
		
	}
	
}
