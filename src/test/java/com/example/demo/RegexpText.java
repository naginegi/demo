package com.example.demo;

import static org.mockito.Mockito.description;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpText {

	// 正規表達式
	// \d代表一個數字，\w 代表az AZ 數字 空白 ，\s
	// \ <--跳脫符號，不能單獨存在，使其後一字失去意義或特殊功用
	// 所以打 \\d 才有 \d 的意思
	// 有特例 \t \f \n 各有其他意思

	@Test
	public void regexpText() {
		String str = "0909-123-456";
		String patter = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";
		String patter1 = "\\d{4}-\\d{3}-\\d{3}";// 省略寫法{}表示重複出現的次數
		String patter2 = "\\d{4}(-\\d{3}){2}"; // 再省略寫法(){2}代表()內的格式出現2次，()代表分組用
		System.out.println(str.matches(patter)); // 比對格式，格式對回傳true
		System.out.println(str.matches(patter1)); // true
		System.out.println(str.matches(patter2)); // true
		System.out.println("===========================");
		String str1 = "(04)-12341234";
		String patter3 = "\\(\\d{2}\\)-\\d{8}"; // 有括號的寫法\\( & \\)
		System.out.println(str1.matches(patter3)); // true
	}

	@Test
	public void regexpText1() {
		// 測試號碼
		/*
		 * 12-1234567 12-12345678 (12)1234567 (12)12345678 123-1234567 123-12345678
		 * (123)1234567 (123)12345678
		 */
		Scanner scan = new Scanner(System.in);
		// 括號內2到3碼後7到8碼 || 前2到3碼-後7到8碼
		String patter = "\\(\\d{2,3}\\)\\d{7,8}||\\d{2,3}-\\d{7,8}";
		while (true) {
			String str = scan.next();
			if (str.matches(patter)) {
				System.out.println("Y");
				break;
			} else {
				System.out.println("N");
			}
		}
	}

	@Test
	public void regexpText2() {
		Scanner scan = new Scanner(System.in);
		//[ - ]可輸入兩數之間的數字、[,,,]只能輸入這幾個數
		//+出現1~無限多次
		//*出現0~無限多次
		//?出現0~1次
		// \\w:A-Z a-z 0-9 _ 			  \\W: \\w以外全部
		// \\d:0-9 						  \\D: \\d以外全部
		// \\s:空白、定位、Tab鍵、換行、換頁字元  \\S: \\s以外全部
		String patter = "[A-Z]\\w{4}\\W?";//開頭1大寫，中間隨意0~4字，尾1字以外符號0~1個
		String patter1 = "[A-Za-z][1,2,3,4]";
		while (true) {
			String str = scan.next();
			if (str.matches(patter)) {
				System.out.println("Y");
				break;
			} else {
				System.out.println("N");
			}
		}
	}
	
	
	@Test
	public void regexpText3() {
		Scanner scan = new Scanner(System.in);
		String patter = "0[1-9]{1,3}-[0-9]{7,8}";
		while (true) {
			String str = scan.next();
			if (str.matches(patter)) {
				System.out.println("Y");
				break;
			} else {
				System.out.println("N");
			}
		}
	}
	
	@Test
	public void regexpText4() {
		//a123456789 d321654987 c321654987 @123456789 Z123456789
		Scanner scan = new Scanner(System.in);
		String str1 = "ABDEFHabdefh";
		System.out.println("輸入身分證字號：");
		String patter = "[A-Za-z&&[^ABDEFHabdefh]][1,2]\\d{8}";
		String patter1 = "[CcGgI-Zi-z][1,2]\\d{8}";
		String patter2 = "[\\w&&[^\\d_"+str1+"]][1,2]\\d{8}";
		while (true) {
			String str = scan.next();
			if (str.matches(patter2)) {
				System.out.println("格式正確");
				break;
			} else {
				System.out.println("格式錯誤，再試一次");
			}
		}
	}
	
	
	@Test
	public void regexpText5() {
		
		// ^練習
		// 第一種用法
		// 當^放在開頭時代表起頭符號，另外結尾符號叫做$
		// "^a" 代表a開頭的回傳true。"b$"代表已b結尾的話回傳true
		// 第二種用法
		// 當^放在[^]中時，當作排除用，*只能放在開頭
		// "[^A-Z]"排除A-Z，有A-Z回傳false
		
		Scanner scan = new Scanner(System.in);
		String patter = "^ab$";
		String patter1 = "[^A-Z]";
		while (true) {
			String str = scan.next();
			if (str.matches(patter)) {
				System.out.println("Y");
//				break;
			} else {
				System.out.println("N");
			}
		}
	}
	
	
	@Test
	public void regexpText6() {
		
		// .萬用字元練習
		// 萬用字元代表除"\n"以外所有字元
		// \\d. 代表有2個字元，第一個是數字，第二個是除"\n"以外所有字元
		// \\w.* 先看\\w 再看.*，第一個[A-Za-z0-9_]，第二個0-多個萬用字元
		
		Scanner scan = new Scanner(System.in);
		String patter = "a.?";// a + 0-1個萬用字元
		while (true) {
			String str = scan.next();
			if (str.matches(patter)) {
				System.out.println("Y");
//				break;
			} else {
				System.out.println("N");
			}
		}
	}
	
	
	@Test
	public void regexpText7() {
		
		// replaceFirst replaceAll
		// First 替換第一個
		// All   替換全部
		
		String str = "hallo java i love java";
		String patter = "java";
		System.out.println(str.replaceFirst(patter,"python")); // hallo python i love java
		System.out.println(str.replaceFirst(patter,"python")); // hallo python i love java
		System.out.println("===============================");
		patter = ".*(java).*";
		// ".*" "java" ".*"
		// (hallo )(java)( i love java)
		// 拆分成3段，第一段符合萬用字元0到多個，第二段為java字串，第三段符合0到多個萬用字元
		// 印出 python
		System.out.println(str.replaceFirst(patter,"python")); 
		System.out.println(str.replaceFirst(patter,"python")); 
		
	}
}
