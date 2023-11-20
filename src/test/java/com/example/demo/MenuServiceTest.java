package com.example.demo;

//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest // �������Qspring boot �U�ު��Ҧ�����
public class MenuServiceTest {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuDao menuDao;

	@Test
	public void addMenuTest() {
//		menuService.addMenu(new Menu("pork", 1000));

		// test ���˹���~�����p
		// �W�� ���� �s�b
		// �W�٬���
		Menu result = menuService.addMenu(new Menu("", 100));
		Assert.isTrue(result == null, "addMenu error");
		// �s�W�����n>0
		result = menuService.addMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "addMenu error");
		// ���`���p
		result = menuService.addMenu(new Menu("fish", 200));
		Assert.isTrue(result != null, "addMenu error");
		// ���L����
		result = menuService.addMenu(new Menu("fish", 50));
		Assert.isTrue(result == null, "addMenu error");
		// �R�����ո��
//		menuDao.deleteById("fish");

	}

	@Test
	public void addMenuListTest() {
//		List<Menu> list = new ArrayList<>();
//		list.add(new Menu("beef", 2000));
//		list.add(new Menu("chicken", 3000));
//		list.add(new Menu("lamb", 4000));
//		menuService.addMenuList(list);
	}

	@Test
	public void updataMenuTest() {
//		menuService.updataMenu(new Menu("beef", 3500));

		// null : �W�� ���� ���s�b
		// �W��
		Menu result = menuService.updataMenu(new Menu("", 100));
		Assert.isTrue(result == null, "error1");
		// ����
		result = menuService.updataMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "error2");
		// ���s�b
		result = menuService.updataMenu(new Menu("fish1", 50));
		Assert.isTrue(result == null, "error3");
		// �W�����s�b ��s���`���p
		result = menuService.updataMenu(new Menu("fish", 250));
		Assert.isTrue(result != null, "error4");
		// �R�����ո��
//		menuDao.deleteById("fish");
	}

	@Test
	public void findByNameTest() {
//		menuService.findByName("beef");
		
		//�W�� ����� �S��� 
		
		Menu result = menuService.findByName("");
		Assert.isTrue(result == null,"error1");
		
		result = menuService.findByName("fish");
		Assert.isTrue(result != null , "error2");
		
		result = menuService.findByName("fish1");
		Assert.isTrue(result == null , "error3");
	}

	@Test
	public void findAllTest() {
//		menuService.findAll();
	}
	/*
	 * @Test public void AllTest() { // ��J�L���b�B�R���Ҧ��B�L�k��s�\�I�W�r
	 * System.out.println("Welcome"); //
	 * System.out.println("1.�d�ݵ��\n2.�s�W�浧�\�I\n3.�s�W�h���\�I\n4.�d���\�I\n5.�ק��\�I\n\n0.���}");
	 * Scanner scan = new Scanner(System.in); // int inputNum = scan.nextInt();
	 * while (true) {
	 * System.out.println("\n1.�d�ݵ��\n2.�s�W�浧�\�I\n3.�s�W�h���\�I\n4.�d���\�I\n5.�ק��\�I����\n\n0.���}");
	 * int inputNum = scan.nextInt(); System.out.println("=================");
	 * switch (inputNum) { case 1: menuService.findAll(); break; case 2:
	 * System.out.println("\n��J�s�W�\�I�W�١G"); String newMenuName = scan.next();
	 * System.out.println("\n��J�s�W�\�I�����G"); int newMenuMoney = scan.nextInt();
	 * System.out.println(""); menuService.addMenu(new Menu(newMenuName,
	 * newMenuMoney)); System.out.println("����"); break; case 3: List<Menu> list =
	 * new ArrayList<>(); while (true) { System.out.println("\n��J�s�W�\�I�W�١G"); String
	 * newMenusName = scan.next(); System.out.println("\n��J�s�W�\�I�����G"); int
	 * newMenusMoney = scan.nextInt(); list.add(new Menu(newMenusName,
	 * newMenusMoney)); System.out.println("\n1.�~��s�W\n2.����\n"); int newMenusNum =
	 * scan.nextInt(); if(newMenusNum == 2) { break; } }
	 * menuService.addMenuList(list); break; case 4:
	 * System.out.println("��J�d���\�I�W�١G"); String findStr = scan.next();
	 * menuService.findByName(findStr); break; case 5:
	 * System.out.println("��J�ק��\�I�W�١G"); String updataStr = scan.next();
	 * menuService.findByName(updataStr); System.out.println("\n��J�ק��\�I�����G"); int
	 * updataMoney = scan.nextInt(); menuService.updataMenu(new Menu(updataStr,
	 * updataMoney)); break; case 0: System.out.println("thank you"); return;
	 * default: return; // break; } System.out.println("================="); }
	 * 
	 * }
	 */

	@Test
	public void Test() {

	}

}
