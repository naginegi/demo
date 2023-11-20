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
		System.out.println("分數(0～100):");
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
		System.out.println("今天星期幾：");
		String week = scan.next();
		int weeknum = 0;
		switch (week) {
		case "一":
			weeknum = 1;
			break;
		case "二":
			weeknum = 2;
			break;
		case "三":
			weeknum = 3;
			break;
		case "四":
			weeknum = 4;
			break;
		case "五":
			weeknum = 5;
			break;
		case "六":
			weeknum = 6;
			break;
		case "日":
			weeknum = 7;
			break;
		default:
			System.out.println("error");
			return;
		}
		
		System.out.println("幾天後星期幾：");
		int num = scan.nextInt();
		int a = (num+ weeknum) % 7;
		switch (a) {
		case 0:
			System.out.printf("%d天後星期日", num);
			break;

		default:
			System.out.printf("%d天後星期%d", num, a);
			break;
		}
		

	}

	
	@Test
	public void switchTest4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("今天星期幾：");
		String week = scan.next();
		int weeknum = 0;
		switch (week) {
		case "一":
			weeknum = 1;
			break;
		case "二":
			weeknum = 2;
			break;
		case "三":
			weeknum = 3;
			break;
		case "四":
			weeknum = 4;
			break;
		case "五":
			weeknum = 5;
			break;
		case "六":
			weeknum = 6;
			break;
		case "日":
			weeknum = 7;
			break;
		default:
			System.out.println("error");
			return;
		}
		
		System.out.println("幾天後星期幾：");
		int num = scan.nextInt();
		int a = (num+ weeknum) % 7;
		switch (a) {
		case 0:
			System.out.printf("%d天後星期日", num);
			break;

		default:
			System.out.printf("%d天後星期%d", num, a);
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
