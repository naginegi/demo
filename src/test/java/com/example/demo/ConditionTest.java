package com.example.demo;

import java.util.Scanner;
import java.util.concurrent.Delayed;

import org.junit.jupiter.api.Test;

import ch.qos.logback.core.util.SystemInfo;

public class ConditionTest {

	@Test
	public void ifTest() {
		double a = Math.floor(Math.random() * 10);
		double r = Math.floor(Math.random() * 10);
		if (a > r) {
			System.out.println("a = " + a + "\t" + "r = " + r + "\t" + "a > r");
		} else {
			System.out.println("a = " + a + "\t" + "r = " + r + "\t" + "a < r");
		}
	}

	@Test
	public void switchTest() {
		Scanner scan = new Scanner(System.in);
		int x;
		x = scan.nextInt();
		switch (x) {
		case 1:
			x++;
			System.out.println("x++ = " + x);
			break;
		case 2:
			x--;
			System.out.println("x-- = " + x);
			break;

		default:
			System.out.println("x = " + x);
			break;
		}

	}

	@Test
	public void switchTest2() {
		System.out.println("����(0��100):");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		switch (num / 10) {
			case 10:
				System.out.println("S");
				break;
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
				break;
		}

	}

	@Test
	public void switchTest3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ѬP���X�G");
		String week = scan.next();
		int weeknum = 0;
		switch (week) {
		case "�@":
			weeknum = 1;
			break;
		case "�G":
			weeknum = 2;
			break;
		case "�T":
			weeknum = 3;
			break;
		case "�|":
			weeknum = 4;
			break;
		case "��":
			weeknum = 5;
			break;
		case "��":
			weeknum = 6;
			break;
		case "��":
			weeknum = 7;
			break;
		default:
			System.out.println("error");
			return;
		}
		
		System.out.println("�X�ѫ�P���X�G");
		int num = scan.nextInt();
		int a = (num+ weeknum) % 7;
		switch (a) {
		case 0:
			System.out.printf("%d�ѫ�P����", num);
			break;

		default:
			System.out.printf("%d�ѫ�P��%d", num, a);
			break;
		}
		

	}

	
	@Test
	public void switchTest4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("���ѬP���X�G");
		String week = scan.next();
		int weeknum = 0;
		switch (week) {
		case "�@":
			weeknum = 1;
			break;
		case "�G":
			weeknum = 2;
			break;
		case "�T":
			weeknum = 3;
			break;
		case "�|":
			weeknum = 4;
			break;
		case "��":
			weeknum = 5;
			break;
		case "��":
			weeknum = 6;
			break;
		case "��":
			weeknum = 7;
			break;
		default:
			System.out.println("error");
			return;
		}
		
		System.out.println("�X�ѫ�P���X�G");
		int num = scan.nextInt();
		int a = (num+ weeknum) % 7;
		switch (a) {
		case 0:
			System.out.printf("%d�ѫ�P����", num);
			break;

		default:
			System.out.printf("%d�ѫ�P��%d", num, a);
			break;
		}
	}
	
	@Test
	public void functionTest() {
		int a= 5;
		int b = functionTest1(a);
		System.out.println(b);
	}
	
	public int functionTest1(int c) {
		int d = c+2;
		return d;
	}
		
	
	@Test
	public void scannerTest() {
		Scanner scan = new Scanner(System.in);
		String a;
		System.out.println("input string:");
		a = scan.nextLine();
		System.out.println(a);
	}
	
	
}
