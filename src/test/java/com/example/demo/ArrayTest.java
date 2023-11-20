package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.support.StandardTypeLocator;
import org.w3c.dom.DOMStringList;

public class ArrayTest {

	@Test
	public void arrayTest() {
		// new 給他一記憶體空間，另外，array屬於 類別(class) 新增要用new
		int arrA[] = new int[10];
		int arrB[] = new int[10];
		
		int arrC[] = {1,2,3};
		arrA[0] = 1;
		arrA[1] = 2;
		arrA[2] = 3;
		arrA[3] = 3;
		
		int [][] arrD =  new int [2][3];
		int [][] arrE = { { 1,2,3 } , {4,5,6} };
		
//		for (int i = 0; i < 10; i++) {
//			arrA[i] = (int) Math.floor(Math.random() * 100 + 1);
//			arrB[i] = arrA[i];
//			System.out.println("A = " + arrA[i]);
//		}
	}

	@Test
	public void listTest() {
		// list 屬於 介湣(interface)，新增沒辦法用new，介面無法new
		// 介面目的為定義方法，裡面沒有實作內容
		// <>內為資料型態，前<>內必填，後<>內可省略
		// 公式：List< "資料型態" > "名稱" = new ArrayList<>();
		// list空間為動態的，陣列宣告時就得設定，為靜態
		// list是有序的，依照加入先後排序
		Random ran = new Random();
		List<Integer> intList = new ArrayList<>();
		List<String> strList = new ArrayList<>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		System.out.println(strList + "\n");

		// list長度
		System.out.println(strList.size() + "\n");

		for (int i = 0; i < strList.size(); i++) {
			// 取得list內資料
			System.out.println(strList.get(i));
		}

		System.out.println("\n===================================\n");

		// list預設給方法，但"長度內容無法修改"
		// 以下2行執行 strList1.add("P"); strList2.add("P"); 會報錯
		List<String> strList1 = List.of("A", "D", "W", "S");
		List<String> strList2 = Arrays.asList("A1", "D1", "W1", "S1");
		// new ArrayList是 動愾空間，可修改長度內容
		List<String> strList3 = new ArrayList<>(List.of("A", "D", "W", "S"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "D1", "W1", "S1"));

		System.out.println("\n===================================\n");
		intList.add(ran.nextInt(100));
		System.out.println(intList);

	}

	@Test
	public void listTest1() {
		// Integer String Long Float Double Char Boolean
		// 開頭變大寫，是一種class 預設值為null
		// List<>裡面一定是放大寫的型態
		List<Integer> intList = new ArrayList<>();
		List<String> strList = new ArrayList<>();

		// 原始資料型態
		// 宣告值的同時給值
		int a = 5;
		Integer a1 = new Integer(5); // 代表此方法現在可用，未來版本將會廢棄，或不建議你使用

		// 參照資料型態
		// 參照：記憶體位置
		// 宣告時給記憶體空間，值再說
		int b[] = new int[5];

	}

	@Test
	public void foreachTest() {
		List<String> strList1 = List.of("A", "D", "W", "S");
		for (int i = 0; i < strList1.size(); i++) {
			System.out.println(strList1.get(i));
		}
		System.out.println("\n===================================\n");
		// 這就是foreach
		for (String item : strList1) {
			System.out.println(item);
		}
		System.out.println("");
		strList1.forEach(item -> {
			System.out.println(item);
		});
	}

	@Test
	public void foreachTest1() {
		Scanner scan = new Scanner(System.in);
		List<Integer> intList = new ArrayList<>();
		int input = scan.nextInt();
		int count = 0;
		for (int j = 1; j <= input; j++) {
			for (int i = 1; i <= j; i++) {
				if (j % i == 0) {
					count++;
				}
			}
			if (count == 2) {
//				System.out.println("Y : " + j);
				intList.add(j);
			} else {
//				System.out.println("N");
			}
			count = 0;
		}
		System.out.println(intList);
	}

	
	
	
	
	
	
	
	
}
