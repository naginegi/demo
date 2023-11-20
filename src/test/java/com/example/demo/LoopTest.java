package com.example.demo;

import static org.mockito.ArgumentMatchers.doubleThat;

import java.util.Random;
import java.util.Random.*;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterName;

import org.junit.jupiter.api.Test;

public class LoopTest {

	@Test
	public void loopTest() {
		System.out.println("============");

		int i = 1;
		int j = 2;
//		System.out.printf("%d+%d = %2d",i,j,i+j*100);
		System.out.println("");
		a: for (i = 0; i <= 5; i++) {
			System.out.println("i = " + i);
			for (j = 0; j <= 5; j++) {
				if (j == 3) {
					break a;// 跳出指定迴圈
				}
				System.out.println("j =" + j);
			}
			System.out.println("============");
		}
	}

	@Test
	public void loopTest2() {
		int ans = (int)(Math.random() * 98) + 2;
		Scanner scan = new Scanner(System.in);
		System.out.println("ans = " + ans);
		int input = 0;
		int min = 1;
		int max = 100;
		int count = 0;
		while (true) {
			System.out.printf("猜一整數:( %d ~ %d )", min, max);
			System.out.println("");
			input = scan.nextInt();
			count++;
			System.out.printf("已猜 %d 次", count);
			System.out.println("");
			if (input == ans) {
				System.out.println("bingo");
				ans = (int)Math.floor(Math.random() * 98 + 2);
				min = 1;
				max = 100;
				count = 0;
				continue;
//				break;
			}
			if (input > max) {
				System.out.println("太大");
			}
			if (input < max && input > ans) {
				max = input;
			}
			if (input < min) {
				System.out.println("太小");
			}
			if (input > min && input < ans) {
				min = input;
			}

			System.out.println("");
			System.out.println("===================");
		}
	}

	@Test
	public void test() {
		for (int i = 0; i < 10000; i++) {
			double ans = Math.floor(Math.random() * 98 + 2);
			if (ans == 1 || ans == 100) {
				System.out.println("error");
			}
		}
		System.out.println("finish");
	}
	
//	@Test
//	public void ranTest() {
//		Random ran = new Random();
//		int b = ran.nextInt(20,50);
//		System.out.println(b);
//
//	}

}
