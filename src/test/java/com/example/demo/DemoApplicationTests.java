package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest  //總之會會執行到main，驗證什麼甚麼的
public class DemoApplicationTests {
//public是權限、void是執行這個方法時會回傳值型態 不回傳就void
	
//////////////////////////////////////////////
	@Test // 練習
	public void xxxTest() {
		
	}
////////////////////////////////////////////
	
	
	
	@Test // 在這test的package裡可以單獨去執行這個，要加這個才能執行
	public void fristTest() {
		int a = 5;
		System.out.println(a);
		String asd = new String();
	}

	@Test // 字串練習
	public void stringTest() {
		String a = new String("abc");
		String b = "ABC";
		int c = 3;
		System.out.println("a="+a+"\t"+"b="+b+c);
		System.out.println(c);
	}
	
	@Test // 練習
	public void Test() {
		
	}
	
	/*
	public void triangle() {
//=======================================================三角形
		System.out.println("================"); 
		  for(int i = 0 ; i <= 5 ; i++) {
			  for(int k = i ; k<5 ; k++) { 
			  System.out.printf(" "); 
			  } 
		  for(int j = 0 ; j < i ; j++) { 
			  System.out.printf("*"); 
			  } 
		  System.out.println(""); 
		  }
		  System.out.println("直角三角1"); 
		  System.out.println("================");
		  for(int i = 0 ; i <= 5 ; i++) { 
			  for(int j = 0 ; j < i ; j++) {
		  System.out.printf("*"); 
		  } 
			  System.out.println(""); 
			  }
		  System.out.println("直角三角2");
		  System.out.println("================"); 
		  for(int i = 0 ; i <= 5 ; i++) { 
			  for(int j = 5 ; j > i ; j--) {
		  System.out.printf("*"); 
		  } 
			  System.out.println(""); 
			  }
		  System.out.println("直角三角3"); 
		  System.out.println("================"); 
		  for(int i = 0 ; i <= 5 ; i++) { 
			  for(int k = 0 ; k<i ; k++) { 
				  System.out.printf(" ");
		  } 
			  for(int j = 5 ; j > i ; j--) { 
				  System.out.printf("*"); 
				  }
		  System.out.println(""); 
		  } 
		  System.out.println("直角三角4");
		  System.out.println("================"); 
		  // i = 0,2,4 j = 0 , 012 , 01234 , k = 1,0 
		  int h = 5; 
		  for(int i = 0 ; i <= 5 ; i+=2) { 
			  for(int k = 0 ; k<=h ; k++) { 
				  System.out.printf(" "); 
				  h= h - 1; 
				  } 
			  for(int j = 0 ; j <= i ; j++) {
		  System.out.printf("*");
		  } System.out.println(""); 
		  } //
		  System.out.println("=======。=。=======");
		  for(int i = 0 ; i < 7 ; i++) {
		  System.out.printf("*");
		  } 
		  System.out.println(); //
		  System.out.println("=======。=。=======");
		  for(int i = 0 ; i <= 5 ; i+=2) {
			  int g = -1; 
			  for(int k = i ; k >=g ; k--) { 
				  System.out.printf(" "); g = g+1; 
				  }
		  for(int j = 5 ; j > i ; j--) {
			  System.out.printf("*"); 
			  }
		  System.out.println(""); 
		  }
		  System.out.println("菱");
		  System.out.println("================");
		  
		  int a ; 
		  int b; 
		  a = 777; System.out.println("a=\t"+a); a=0b1111;
		  System.out.println("a=\t"+a); b=045; System.out.println("b=\t"+b); b=0x8A;
		  System.out.println("b=\t"+b); System.out.println("資料型態");
		  System.out.println("================");
		  
	}
	 */

}
