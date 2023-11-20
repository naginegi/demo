package com.example.demo;

import static org.mockito.Mockito.description;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpText {

	// ���W��F��
	// \d�N��@�ӼƦr�A\w �N��az AZ �Ʀr �ť� �A\s
	// \ <--����Ÿ��A�����W�s�b�A�Ϩ��@�r���h�N�q�ίS��\��
	// �ҥH�� \\d �~�� \d ���N��
	// ���S�� \t \f \n �U����L�N��

	@Test
	public void regexpText() {
		String str = "0909-123-456";
		String patter = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";
		String patter1 = "\\d{4}-\\d{3}-\\d{3}";// �ٲ��g�k{}��ܭ��ƥX�{������
		String patter2 = "\\d{4}(-\\d{3}){2}"; // �A�ٲ��g�k(){2}�N��()�����榡�X�{2���A()�N����ե�
		System.out.println(str.matches(patter)); // ���榡�A�榡��^��true
		System.out.println(str.matches(patter1)); // true
		System.out.println(str.matches(patter2)); // true
		System.out.println("===========================");
		String str1 = "(04)-12341234";
		String patter3 = "\\(\\d{2}\\)-\\d{8}"; // ���A�����g�k\\( & \\)
		System.out.println(str1.matches(patter3)); // true
	}

	@Test
	public void regexpText1() {
		// ���ո��X
		/*
		 * 12-1234567 12-12345678 (12)1234567 (12)12345678 123-1234567 123-12345678
		 * (123)1234567 (123)12345678
		 */
		Scanner scan = new Scanner(System.in);
		// �A����2��3�X��7��8�X || �e2��3�X-��7��8�X
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
		//[ - ]�i��J��Ƥ������Ʀr�B[,,,]�u���J�o�X�Ӽ�
		//+�X�{1~�L���h��
		//*�X�{0~�L���h��
		//?�X�{0~1��
		// \\w:A-Z a-z 0-9 _ 			  \\W: \\w�H�~����
		// \\d:0-9 						  \\D: \\d�H�~����
		// \\s:�ťաB�w��BTab��B����B�����r��  \\S: \\s�H�~����
		String patter = "[A-Z]\\w{4}\\W?";//�}�Y1�j�g�A�����H�N0~4�r�A��1�r�H�~�Ÿ�0~1��
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
		System.out.println("��J�����Ҧr���G");
		String patter = "[A-Za-z&&[^ABDEFHabdefh]][1,2]\\d{8}";
		String patter1 = "[CcGgI-Zi-z][1,2]\\d{8}";
		String patter2 = "[\\w&&[^\\d_"+str1+"]][1,2]\\d{8}";
		while (true) {
			String str = scan.next();
			if (str.matches(patter2)) {
				System.out.println("�榡���T");
				break;
			} else {
				System.out.println("�榡���~�A�A�դ@��");
			}
		}
	}
	
	
	@Test
	public void regexpText5() {
		
		// ^�m��
		// �Ĥ@�إΪk
		// ��^��b�}�Y�ɥN��_�Y�Ÿ��A�t�~�����Ÿ��s��$
		// "^a" �N��a�}�Y���^��true�C"b$"�N��wb�������ܦ^��true
		// �ĤG�إΪk
		// ��^��b[^]���ɡA��@�ư��ΡA*�u���b�}�Y
		// "[^A-Z]"�ư�A-Z�A��A-Z�^��false
		
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
		
		// .�U�Φr���m��
		// �U�Φr���N��"\n"�H�~�Ҧ��r��
		// \\d. �N��2�Ӧr���A�Ĥ@�ӬO�Ʀr�A�ĤG�ӬO��"\n"�H�~�Ҧ��r��
		// \\w.* ����\\w �A��.*�A�Ĥ@��[A-Za-z0-9_]�A�ĤG��0-�h�ӸU�Φr��
		
		Scanner scan = new Scanner(System.in);
		String patter = "a.?";// a + 0-1�ӸU�Φr��
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
		// First �����Ĥ@��
		// All   ��������
		
		String str = "hallo java i love java";
		String patter = "java";
		System.out.println(str.replaceFirst(patter,"python")); // hallo python i love java
		System.out.println(str.replaceFirst(patter,"python")); // hallo python i love java
		System.out.println("===============================");
		patter = ".*(java).*";
		// ".*" "java" ".*"
		// (hallo )(java)( i love java)
		// �����3�q�A�Ĥ@�q�ŦX�U�Φr��0��h�ӡA�ĤG�q��java�r��A�ĤT�q�ŦX0��h�ӸU�Φr��
		// �L�X python
		System.out.println(str.replaceFirst(patter,"python")); 
		System.out.println(str.replaceFirst(patter,"python")); 
		
	}
}
