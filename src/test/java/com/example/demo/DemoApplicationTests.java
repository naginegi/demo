package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest  //�`���|�|�����main�A���Ҥ���ƻ�
public class DemoApplicationTests {
//public�O�v���Bvoid�O����o�Ӥ�k�ɷ|�^�ǭȫ��A ���^�ǴNvoid
	
//////////////////////////////////////////////
	@Test // �m��
	public void xxxTest() {
		
	}
////////////////////////////////////////////
	
	
	
	@Test // �b�otest��package�̥i�H��W�h����o�ӡA�n�[�o�Ӥ~�����
	public void fristTest() {
		int a = 5;
		System.out.println(a);
		String asd = new String();
	}

	@Test // �r��m��
	public void stringTest() {
		String a = new String("abc");
		String b = "ABC";
		int c = 3;
		System.out.println("a="+a+"\t"+"b="+b+c);
		System.out.println(c);
	}
	
	@Test // �m��
	public void Test() {
		
	}
	
	/*
	public void triangle() {
//=======================================================�T����
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
		  System.out.println("�����T��1"); 
		  System.out.println("================");
		  for(int i = 0 ; i <= 5 ; i++) { 
			  for(int j = 0 ; j < i ; j++) {
		  System.out.printf("*"); 
		  } 
			  System.out.println(""); 
			  }
		  System.out.println("�����T��2");
		  System.out.println("================"); 
		  for(int i = 0 ; i <= 5 ; i++) { 
			  for(int j = 5 ; j > i ; j--) {
		  System.out.printf("*"); 
		  } 
			  System.out.println(""); 
			  }
		  System.out.println("�����T��3"); 
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
		  System.out.println("�����T��4");
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
		  System.out.println("=======�C=�C=======");
		  for(int i = 0 ; i < 7 ; i++) {
		  System.out.printf("*");
		  } 
		  System.out.println(); //
		  System.out.println("=======�C=�C=======");
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
		  System.out.println("��");
		  System.out.println("================");
		  
		  int a ; 
		  int b; 
		  a = 777; System.out.println("a=\t"+a); a=0b1111;
		  System.out.println("a=\t"+a); b=045; System.out.println("b=\t"+b); b=0x8A;
		  System.out.println("b=\t"+b); System.out.println("��ƫ��A");
		  System.out.println("================");
		  
	}
	 */

}
