package com.example.demo;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.SeparatorUI;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.util.StringUtils;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {
	// string是一個類別，一般來講類別要用new，但string可以不用，用 = 即可賦予值給他

	@Test
	public void stringTest() {
		String str = "abc";
		String str1 = new String("abc");
		String str2 = "abc";
		System.out.println(str == str1);// false，因為比較記憶體位置
		System.out.println(str == str2);
		// true，有個東西叫做字串池(String Pool)，str在宣告時已將"abc"放進去。
		// str2在宣告時，在字串池找是否有"abc"這東西，有則指向他。
		// 所以，str、str2 是找到同個"abc"。 str == str2 為true。
		// 如果這時將 str = "abcd" ，原本的"abc"不會消失，但會在字串池新增一個"abcd"並指向他。
		System.out.println(str.equals(str1));// true，字串比較，就比較他們裡面的值
		String str3 = "ABC";
		System.out.println(str.equals(str3));// false，在程式碼裡，大小寫是不一樣的東西
		System.out.println(str.equalsIgnoreCase(str3));// true，忽略大小寫比較的方法
	}

	@Test
	public void stringTest1() {
		// 字串長度
		String str = "abc";
		String str1 = "";
		String str2 = "   ";
		System.out.println(str.length()); // 3
		System.out.println(str1.length());// 0
		System.out.println(str2.length());// 3
		System.out.println("====================");
		// 字串比較 (is放前面通常是布林值)
		// isEmpty()檢測 長度是否為0，是則true
		System.out.println(str.isEmpty()); // false
		System.out.println(str1.isEmpty());// true
		System.out.println(str2.isEmpty());// false
		System.out.println("====================");
		// isBlank()檢測是 長度是否為0 或 是否全空白 ，是則true
		System.out.println(str.isBlank()); // false
		System.out.println(str1.isBlank());// true
		System.out.println(str2.isBlank());// true
		System.out.println("====================");
	}

	@Test
	public void stringTest2() {
		Dog dog = new Dog();
		String name = dog.getName();
		String color = dog.getColor();
		System.out.println(name); // dog
		System.out.println(color);// null
		System.out.println("====================");
		// null印不出來，會報錯 null.(任何方法) 都會報錯
		// System.out.println(color.length());
		// 判斷是否null
		System.out.println(color == null); // true

		System.out.println("====================");
		// 先判斷是否為null，再判斷裡免是否有東西，不過通常不會這樣寫
		// 必須先寫null，先寫isBlank的話，null.(任何方法) 會報錯
		if (color == null || color.isBlank()) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}

		System.out.println("====================");
		System.out.println(StringUtils.hasLength(" ")); // 有沒有長度 有true
		System.out.println(StringUtils.hasText(" ")); // 有沒有內容 沒有false

		System.out.println("====================");
		System.out.printf("是否是空字串：");
		if (!StringUtils.hasText(color)) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}

	@Test
	public void stringTest3() {
		String str = "神鵰俠侶是楊過與楊過的故事，我不喜歡楊過的甲仙，雖然在楊過眼中是清新脫俗";
		String ans = "楊過";
		int x = str.indexOf(ans);
		int count = 0;
		while (x != -1) {
			System.out.println("出現位置：" + x);
			x = str.indexOf(ans, x + ans.length());
			count++;
		}
		System.out.println("共出現：" + count);
	}

	@Test
	public void stringTest4() {
		StringBuffer sb = new StringBuffer();
		String str = "ABACADEF";
		String strold = "";
		String strnew = "";
		String ans = "A";
		int x = str.indexOf(ans);
		int last = 0;
		while (x != -1) {
			last = x;
			x = str.indexOf(ans, x + ans.length());
		}
		sb.append("");
		strnew = str.substring(last, str.length());
		strold = str.substring(0, last);
		strnew = strnew.replace("A", "W");
		System.out.println("原句子是：ABACADEF");
		System.out.println("更改後：" + strold + strnew);
	}

	@Test
	public void stringTest5() {
		StringBuffer sb = new StringBuffer();
		String str = "ABACADEF";
		int last = str.lastIndexOf("A");
		sb.append(str.substring(0, last)).append((str.substring(last, str.length()).replace("A", "W")));
		System.out.println("原句是：" + str);
		System.out.println("更改後：" + sb);
	}

	@Test
	public void replaceTest() {
		String str = "神鵰俠侶是楊過與楊過楊過的故事，我不喜歡楊過的甲仙楊過，雖然楊過在楊過眼中楊過是清新脫俗";
		str = str.replace("楊", "陳");
		System.out.println(str);
		System.out.println("==============");
		str = str.replaceAll("陳", "龍女");
		System.out.println(str);
		// replace replaceall 都是取代全部，all跟正規表達式(regex)有關...

	}

	@Test
	public void splitTest() {
		// 遇到"楊過"就刪掉
		String str = "神鵰俠侶是楊過與楊過的故事，我不喜歡楊過的甲仙，雖然在楊過眼中是清新脫俗";
		String[] strarr = str.split("楊過");
		for (String item : strarr) {
			System.out.println(item);
		}
		String str1 = "ABCD";
		String[] str1arr = str1.split("");
		for (String string : str1arr) {
			System.out.println(string);
		}
	}

	@Test
	public void trimTest() {
		// 刪除前後空白
		String str = " asa fdsf xv   ";
		System.out.println(str);
		String str1 = str.trim();
		System.out.println("trim ： " + str1);
		// 去空白
		String str2 = str.replace(" ", "");
		System.out.println("replace ： " + str2);

		String strarr[] = str.split(" ");
		System.out.printf("split ： ");
		for (String string : strarr) {
			System.out.printf(string);
		}
	}

	@Test
	public void substringTest() {
		String str = "神鵰俠侶是楊過與楊過的故事，我不喜歡楊過的甲仙，雖然在楊過眼中是清新脫俗";
		System.out.println(str.substring(5, 10)); // 擷取index:5~9 的字
		System.out.println(str.substring(2)); // 擷取index:2以後字
	}

	@Test
	public void stringbufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		// 附加上去，可以連續打
		sb.append("aSDA");
		sb.append("ASD").append("FSD");
		System.out.println(sb);
	}

	@Test
	public void stringbufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1)); // 他不是字串，印出false
		System.out.println(sb.toString().equals(sb1.toString()));
		// 轉成字串，就能比較，印出true
	}

	@Test
	public void reverseTest() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String input = scan.next();
			if (input.length() <= 1) {
				System.out.println("try again");
				continue;
			}
			StringBuffer sb = new StringBuffer(input);
			System.out.println("是否為迴文：" + input.equals(sb.reverse().toString()));
			break;
		}

	}
	
	
	@Test
	public void listTest() {
		Scanner scan = new Scanner(System.in);
		while(true) {			
		int input = scan.nextInt()+1;
		String str = String.valueOf(input);
		String []arr = str.split("");
		System.out.println(Arrays.asList(arr));
		}
	}
}
