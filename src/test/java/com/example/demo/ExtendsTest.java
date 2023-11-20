package com.example.demo;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.A;
import com.example.demo.entity.A1;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.C;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;

public class ExtendsTest {

	@Test
	public void extendsTest() {
		System.out.println("====================");
		Animal ani = new Animal();
		System.out.println("父類別(Animal)");
		System.out.println("name：" + ani.getName());
		ani.eat();
		ani.sleep();

		System.out.println("====================");
		System.out.println("子類別(bird)");
		Bird bird = new Bird();// 在啟動子類別之前，會先啟動父類別的建構方法
		System.out.println("oldName：" + bird.getName());// 這是父類別的方法
		bird.setName("Huh");// 這是父類別的方法
		System.out.println("newName：" + bird.getName());// 這是父類別的方法
		bird.eat();// 若子類別有同名方法，執行子類別方法，因為@Override
		bird.sleep();
		bird.fly();// 這是子類別的方法

		System.out.println("====================");
		System.out.println("子類別(cat)");
		Cat cat = new Cat();
		System.out.println("name：" + cat.getName());
		cat.eat(); // 父類別方法
		cat.sleep(); // 父子同名方法，子類別@Override，執行子類別方法
		cat.meow(); // 子類別方法
	}

	@Test
	public void extendsTest1() {
		// 檢測父子關係
		Bird bird = new Bird();
		System.out.println((bird instanceof Animal));// true

	}

	@Test
	public void extendsTest2() {
		// 組合，使用extends
		// 父子層關係用法
		A a = new A();
		a.setCity("789");
		System.out.println(a.getCity());

		// 聚合，沒有用extends方式
		// getC表示取得C裡的屬性方法，後可接set get等方法
		A1 a1 = new A1();
		a1.getC().setCity("777");
		System.out.println(a1.getC().getCity());

	}

	@Test
	public void extendsTest3() {
		// 預設方法給值
		C c = new C("aaa", "bbb", "ccc");
		// A1 裡 setC 使用方式
		A1 a1 = new A1();
		a1.setC(c);
		System.out.println("city : " + a1.getC().getCity());
		System.out.println("state : " + a1.getC().getState());
		System.out.println("country : " + a1.getC().getCountry());

	}

	@Test
	public void extendsTest4() {
		// 多形 前面藍字叫接收型態 用父類別接只能用父類別方法，實際上執行的是子類別的方法

		Animal ani = new Animal();
		ani.eat(); // 接收型態父類別 執行Animal內的eat()

		Cat cat = new Cat();
		cat.eat(); // 接收型態子類別內無eat() 執行Animal內的eat()

		Bird bird = new Bird();
		bird.eat();// 接收型態子類別內有eat() 執行Bird內的eat()

		System.out.println("=================");

		Animal anii = new Animal();
		anii.eat(); // 接收型態父類別 執行Animal內的eat()

		Animal catt = new Cat();
		catt.eat();
		// 接收型態父類別 執行Animal內的eat()
		// 但無法執行子類別Cat中的meow()

		Animal birdd = new Bird();
		birdd.eat();
		// 接收型態父類別 執行Animal內的eat()，但子類別中有同名方法eat()
		// @Override 後會執行子類別的實作內容
		
		System.out.println("=================");

		Animal anim = new Animal();
		Animal ca = new Cat();
		Animal bir = new Bird();
		
		anim.aniAction(new Animal());
		anim.aniAction(ca);
		anim.aniAction(new Bird());
				
	}
	
	@Test
	public void extendsTest5() {
		//介面
		Car car = new Car();
		car.run();
		Dog dog = new Dog();
		dog.run();
	}
}
