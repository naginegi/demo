package com.example.demo;

//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@SpringBootTest // 執行任何被spring boot 託管的所有物件
public class MenuServiceTest {

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuDao menuDao;

	@Test
	public void addMenuTest() {
//		menuService.addMenu(new Menu("pork", 1000));

		// test 為檢察錯誤的情況
		// 名錯 錢錯 存在
		// 名稱為空
		Menu result = menuService.addMenu(new Menu("", 100));
		Assert.isTrue(result == null, "addMenu error");
		// 新增價錢要>0
		result = menuService.addMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "addMenu error");
		// 正常情況
		result = menuService.addMenu(new Menu("fish", 200));
		Assert.isTrue(result != null, "addMenu error");
		// 有無重複
		result = menuService.addMenu(new Menu("fish", 50));
		Assert.isTrue(result == null, "addMenu error");
		// 刪除測試資料
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

		// null : 名錯 錢錯 不存在
		// 名錯
		Menu result = menuService.updataMenu(new Menu("", 100));
		Assert.isTrue(result == null, "error1");
		// 錢錯
		result = menuService.updataMenu(new Menu("chicken", 0));
		Assert.isTrue(result == null, "error2");
		// 不存在
		result = menuService.updataMenu(new Menu("fish1", 50));
		Assert.isTrue(result == null, "error3");
		// 名對錢對存在 更新正常情況
		result = menuService.updataMenu(new Menu("fish", 250));
		Assert.isTrue(result != null, "error4");
		// 刪除測試資料
//		menuDao.deleteById("fish");
	}

	@Test
	public void findByNameTest() {
//		menuService.findByName("beef");
		
		//名空 有找到 沒找到 
		
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
	 * @Test public void AllTest() { // 輸入無防呆、刪除模式、無法更新餐點名字
	 * System.out.println("Welcome"); //
	 * System.out.println("1.查看菜單\n2.新增單筆餐點\n3.新增多筆餐點\n4.查詢餐點\n5.修改餐點\n\n0.離開");
	 * Scanner scan = new Scanner(System.in); // int inputNum = scan.nextInt();
	 * while (true) {
	 * System.out.println("\n1.查看菜單\n2.新增單筆餐點\n3.新增多筆餐點\n4.查詢餐點\n5.修改餐點價錢\n\n0.離開");
	 * int inputNum = scan.nextInt(); System.out.println("=================");
	 * switch (inputNum) { case 1: menuService.findAll(); break; case 2:
	 * System.out.println("\n輸入新增餐點名稱："); String newMenuName = scan.next();
	 * System.out.println("\n輸入新增餐點價錢："); int newMenuMoney = scan.nextInt();
	 * System.out.println(""); menuService.addMenu(new Menu(newMenuName,
	 * newMenuMoney)); System.out.println("完成"); break; case 3: List<Menu> list =
	 * new ArrayList<>(); while (true) { System.out.println("\n輸入新增餐點名稱："); String
	 * newMenusName = scan.next(); System.out.println("\n輸入新增餐點價錢："); int
	 * newMenusMoney = scan.nextInt(); list.add(new Menu(newMenusName,
	 * newMenusMoney)); System.out.println("\n1.繼續新增\n2.完成\n"); int newMenusNum =
	 * scan.nextInt(); if(newMenusNum == 2) { break; } }
	 * menuService.addMenuList(list); break; case 4:
	 * System.out.println("輸入查詢餐點名稱："); String findStr = scan.next();
	 * menuService.findByName(findStr); break; case 5:
	 * System.out.println("輸入修改餐點名稱："); String updataStr = scan.next();
	 * menuService.findByName(updataStr); System.out.println("\n輸入修改餐點價錢："); int
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
