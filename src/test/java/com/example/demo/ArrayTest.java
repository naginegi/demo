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
		// new ���L�@�O����Ŷ��A�t�~�Aarray�ݩ� ���O(class) �s�W�n��new
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
		// list �ݩ� ���C(interface)�A�s�W�S��k��new�A�����L�knew
		// �����ت����w�q��k�A�̭��S����@���e
		// <>������ƫ��A�A�e<>������A��<>���i�ٲ�
		// �����GList< "��ƫ��A" > "�W��" = new ArrayList<>();
		// list�Ŷ����ʺA���A�}�C�ŧi�ɴN�o�]�w�A���R�A
		// list�O���Ǫ��A�̷ӥ[�J����Ƨ�
		Random ran = new Random();
		List<Integer> intList = new ArrayList<>();
		List<String> strList = new ArrayList<>();
		strList.add("A");
		strList.add("B");
		strList.add("C");
		System.out.println(strList + "\n");

		// list����
		System.out.println(strList.size() + "\n");

		for (int i = 0; i < strList.size(); i++) {
			// ���olist�����
			System.out.println(strList.get(i));
		}

		System.out.println("\n===================================\n");

		// list�w�]����k�A��"���פ��e�L�k�ק�"
		// �H�U2����� strList1.add("P"); strList2.add("P"); �|����
		List<String> strList1 = List.of("A", "D", "W", "S");
		List<String> strList2 = Arrays.asList("A1", "D1", "W1", "S1");
		// new ArrayList�O �ʷZ�Ŷ��A�i�ק���פ��e
		List<String> strList3 = new ArrayList<>(List.of("A", "D", "W", "S"));
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "D1", "W1", "S1"));

		System.out.println("\n===================================\n");
		intList.add(ran.nextInt(100));
		System.out.println(intList);

	}

	@Test
	public void listTest1() {
		// Integer String Long Float Double Char Boolean
		// �}�Y�ܤj�g�A�O�@��class �w�]�Ȭ�null
		// List<>�̭��@�w�O��j�g�����A
		List<Integer> intList = new ArrayList<>();
		List<String> strList = new ArrayList<>();

		// ��l��ƫ��A
		// �ŧi�Ȫ��P�ɵ���
		int a = 5;
		Integer a1 = new Integer(5); // �N����k�{�b�i�ΡA���Ӫ����N�|�o��A�Τ���ĳ�A�ϥ�

		// �ѷӸ�ƫ��A
		// �ѷӡG�O�����m
		// �ŧi�ɵ��O����Ŷ��A�ȦA��
		int b[] = new int[5];

	}

	@Test
	public void foreachTest() {
		List<String> strList1 = List.of("A", "D", "W", "S");
		for (int i = 0; i < strList1.size(); i++) {
			System.out.println(strList1.get(i));
		}
		System.out.println("\n===================================\n");
		// �o�N�Oforeach
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
