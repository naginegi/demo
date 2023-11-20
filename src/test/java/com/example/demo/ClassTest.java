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
		// �i���ͦh�ӡA�A�h�w�q�ݩʭ�
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
		// �۩w�q��k�A�@���]�w�h���ݩʭȡA���@�뤣�|�o�˰��A����L��k�i��
		Dog dog = new Dog();
//		dog.setAttributes("bara", "green", 55);
		System.out.printf("name:%s,color:%s,age:%d", dog.getName(), dog.getColor(), dog.getAge());
	}

	@Test
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		// ����   �p�G����S�F��(����false)�A��ܦr��"saving error"�A�åB����{��
		Assert.isTrue(bank.getBalance() == 100, "saving error");
		bank.saving(500);//�o��500�s��"���"�A�N���ڶǤJ���Ѽ�
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 1500, "saving error");
		bank.withdraw(800);
		System.out.println(bank.getBalance());
		Assert.isTrue(bank.getBalance() == 700, "saving error");

		
	}
	
	
	@Test
	public void classTest3() {
		//�L�X�ɮצ�m+�ɮצW��+�O�����m
		System.out.println(new TaipeiBank());
		Dog dog = new Dog();
		System.out.println(dog);
		System.out.println("===============");
		Dog dogg = new Dog();
		System.out.println(dogg);
		Dog doggg = dog;
		//dog��doggg�P�ӰO�����m dogg���P
		//== �ȥΨӤ���O�����m�ΤK�ظ�ƫ��A�A�٦����L��
		System.out.println(dog == dogg);//false
		System.out.println("==============");
		System.out.println(dog == doggg);//true
		
	}

	
	@Test
	public void classTest4() {
		//== �ȥΨӤ���O�����m�ΤK�ظ�ƫ��A(���ޤj�p�g)
		System.out.println("==============");
		//����ƭȡA�L�Xfalse
		int a = 5,b = 4;
		System.out.println("int�G" + (a == b));
		System.out.println("==============");
		//�L�Xtrue
		char a1 = 'z',b1 = 'z';
		System.out.println(a1 == b1);
		System.out.println("==============");
		//�u�n��new �N�O�@�ӷs���O����Ŷ��A�L�Xfalse;
		//���L�b�K�ظ�ƫ��A���S���H�|�o�˼g
		//��new�� ������N�O�O�����m
		Integer a2 = new Integer(10);
		Integer b2 = new Integer(10);
		System.out.println(a2 == b2);
		System.out.println("==============");
		//�]�i������L��
		boolean bool1 = true;
		boolean bool2 = true;
		Boolean bool3 = true;
		System.out.println(bool1 == bool2);//true
		System.out.println(bool1 == bool3);//true
		System.out.println("==============");
		//����r��A�L�Xtrue (?)�A����r���equals�A��StringTest
		String str1 = "123";
		String str2 = "123";
		System.out.println(str1 == str2);
		System.out.println("==============");
	}
	
	
	@Test
	public void classTest5() {
		//�@���k
		Dog dog = new Dog();
		dog.setAge(50);
		dog.setColor("red");
		dog.setName("EE");
		System.out.println("=============");
		//�ϥιw�]�غc��k�]��
		Dog dogg = new Dog("WW","AAA",5);
		System.out.println("=============");
	}
	
	
	@Test
	public void classTest6() {
		Dog dog = new Dog();
		dog.setAttributes();//�@���k�I�s�A�����������Onew�X��
		Dog.setAttributes2();//static��k���I�s�A���������O�W��.static��k
		System.out.println("===========================");
		Math.random();
		Random ran = new Random();
		final int a = 5; //�N��a����A�Q���A�q�`�Ω�`�q
		// a = 6; �|error
		
	}
	
}
