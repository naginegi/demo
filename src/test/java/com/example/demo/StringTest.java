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
	// string�O�@�����O�A�@��������O�n��new�A��string�i�H���ΡA�� = �Y�i�ᤩ�ȵ��L

	@Test
	public void stringTest() {
		String str = "abc";
		String str1 = new String("abc");
		String str2 = "abc";
		System.out.println(str == str1);// false�A�]������O�����m
		System.out.println(str == str2);
		// true�A���ӪF��s���r���(String Pool)�Astr�b�ŧi�ɤw�N"abc"��i�h�C
		// str2�b�ŧi�ɡA�b�r�����O�_��"abc"�o�F��A���h���V�L�C
		// �ҥH�Astr�Bstr2 �O���P��"abc"�C str == str2 ��true�C
		// �p�G�o�ɱN str = "abcd" �A�쥻��"abc"���|�����A���|�b�r����s�W�@��"abcd"�ë��V�L�C
		System.out.println(str.equals(str1));// true�A�r�����A�N����L�̸̭�����
		String str3 = "ABC";
		System.out.println(str.equals(str3));// false�A�b�{���X�̡A�j�p�g�O���@�˪��F��
		System.out.println(str.equalsIgnoreCase(str3));// true�A�����j�p�g�������k
	}

	@Test
	public void stringTest1() {
		// �r�����
		String str = "abc";
		String str1 = "";
		String str2 = "   ";
		System.out.println(str.length()); // 3
		System.out.println(str1.length());// 0
		System.out.println(str2.length());// 3
		System.out.println("====================");
		// �r���� (is��e���q�`�O���L��)
		// isEmpty()�˴� ���׬O�_��0�A�O�htrue
		System.out.println(str.isEmpty()); // false
		System.out.println(str1.isEmpty());// true
		System.out.println(str2.isEmpty());// false
		System.out.println("====================");
		// isBlank()�˴��O ���׬O�_��0 �� �O�_���ť� �A�O�htrue
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
		// null�L���X�ӡA�|���� null.(�����k) ���|����
		// System.out.println(color.length());
		// �P�_�O�_null
		System.out.println(color == null); // true

		System.out.println("====================");
		// ���P�_�O�_��null�A�A�P�_�̧K�O�_���F��A���L�q�`���|�o�˼g
		// �������gnull�A���gisBlank���ܡAnull.(�����k) �|����
		if (color == null || color.isBlank()) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}

		System.out.println("====================");
		System.out.println(StringUtils.hasLength(" ")); // ���S������ ��true
		System.out.println(StringUtils.hasText(" ")); // ���S�����e �S��false

		System.out.println("====================");
		System.out.printf("�O�_�O�Ŧr��G");
		if (!StringUtils.hasText(color)) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
	}

	@Test
	public void stringTest3() {
		String str = "����L�Q�O���L�P���L���G�ơA�ڤ����w���L���ҥP�A���M�b���L�����O�M�s��U";
		String ans = "���L";
		int x = str.indexOf(ans);
		int count = 0;
		while (x != -1) {
			System.out.println("�X�{��m�G" + x);
			x = str.indexOf(ans, x + ans.length());
			count++;
		}
		System.out.println("�@�X�{�G" + count);
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
		System.out.println("��y�l�O�GABACADEF");
		System.out.println("����G" + strold + strnew);
	}

	@Test
	public void stringTest5() {
		StringBuffer sb = new StringBuffer();
		String str = "ABACADEF";
		int last = str.lastIndexOf("A");
		sb.append(str.substring(0, last)).append((str.substring(last, str.length()).replace("A", "W")));
		System.out.println("��y�O�G" + str);
		System.out.println("����G" + sb);
	}

	@Test
	public void replaceTest() {
		String str = "����L�Q�O���L�P���L���L���G�ơA�ڤ����w���L���ҥP���L�A���M���L�b���L�������L�O�M�s��U";
		str = str.replace("��", "��");
		System.out.println(str);
		System.out.println("==============");
		str = str.replaceAll("��", "�s�k");
		System.out.println(str);
		// replace replaceall ���O���N�����Aall�򥿳W��F��(regex)����...

	}

	@Test
	public void splitTest() {
		// �J��"���L"�N�R��
		String str = "����L�Q�O���L�P���L���G�ơA�ڤ����w���L���ҥP�A���M�b���L�����O�M�s��U";
		String[] strarr = str.split("���L");
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
		// �R���e��ť�
		String str = " asa fdsf xv   ";
		System.out.println(str);
		String str1 = str.trim();
		System.out.println("trim �G " + str1);
		// �h�ť�
		String str2 = str.replace(" ", "");
		System.out.println("replace �G " + str2);

		String strarr[] = str.split(" ");
		System.out.printf("split �G ");
		for (String string : strarr) {
			System.out.printf(string);
		}
	}

	@Test
	public void substringTest() {
		String str = "����L�Q�O���L�P���L���G�ơA�ڤ����w���L���ҥP�A���M�b���L�����O�M�s��U";
		System.out.println(str.substring(5, 10)); // �^��index:5~9 ���r
		System.out.println(str.substring(2)); // �^��index:2�H��r
	}

	@Test
	public void stringbufferTest() {
		StringBuffer sb = new StringBuffer("ABC");
		// ���[�W�h�A�i�H�s��
		sb.append("aSDA");
		sb.append("ASD").append("FSD");
		System.out.println(sb);
	}

	@Test
	public void stringbufferTest1() {
		StringBuffer sb = new StringBuffer("ABC");
		StringBuffer sb1 = new StringBuffer("ABC");
		System.out.println(sb.equals(sb1)); // �L���O�r��A�L�Xfalse
		System.out.println(sb.toString().equals(sb1.toString()));
		// �ন�r��A�N�����A�L�Xtrue
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
			System.out.println("�O�_���j��G" + input.equals(sb.reverse().toString()));
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
