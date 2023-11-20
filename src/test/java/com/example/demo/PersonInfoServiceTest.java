package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

//import antlr.collections.List;

@SpringBootTest
public class PersonInfoServiceTest {

	@Autowired
	private PersonInfoService personInfoService;

	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void personInfoServiceTest() {
		personInfoService.addInfo(new PersonInfo("A123456788", "negi", 23, "taiah"));
		personInfoService.addInfo(new PersonInfo("A323456789", "negii", 24, "taibh"));
		personInfoService.addInfo(new PersonInfo("1123456789", "negiii", 25, "taich"));
		personInfoService.addInfo(new PersonInfo("A12345678", "negiiii", 26, "taidh"));
		personInfoService.addInfo(new PersonInfo(null, "negiiiii", 27, "taieh"));
	}

	@Test
	public void daoSaveAllTest() {
		// 裡面放List
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123147852", "negi", 23, "taiah"));
		list.add(new PersonInfo("E177777777", "negi", 23, "taiah"));
		personInfoDao.saveAll(list);
	}

	@Test
	public void daoAllTest2() {
		// 裡面放List
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123456789", "negi", 23, "taich"));
		list.add(new PersonInfo("E222222222", "negi", 23, "taich"));
		list.add(new PersonInfo("E222222223", "negi", 23, "taich"));
		list.add(new PersonInfo("E222222224", "negi", 23, "taich"));
		list.add(new PersonInfo("E222222225", "negi", 23, "taich"));
		personInfoService.addInfoList(list);
	}

	@Test
	public void daoFindTest() {
		// 用Id找的寫法
		Optional<PersonInfo> infoOp = personInfoDao.findById("E222222222");
		if (infoOp.isEmpty()) {
			System.out.println("Not found");// 找不到就not found
		} else {
			System.out.println(infoOp.get().getName());// 找到所許ID的name
		}
	}

	@Test
	public void daoFindTest2() {
		List<PersonInfo> list = new ArrayList<>(personInfoDao.findAll());
		for (PersonInfo item : list) {
			System.out.println(item.getId());
		}
	}

	@Test
	public void daoFindTest3() {
		// 自定義方法，找city
		List<PersonInfo> result = personInfoDao.findByCity("taich");
		List<PersonInfo> result1 = personInfoDao.findByNameAndCity(null, null);
		for (PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}

	@Test
	public void daoExistsTest() {
		// exists 輸出為布林值
		System.out.println(personInfoDao.existsById("A123456789"));// true
		// findbyid 撈出來是資料，用在後續需要操作的地方
		// existsbyid 單純判斷資料存不存在 例：防同個帳號註冊
	}

	@Test
	public void addInfoTest() {
		// 格式 null 重複
		// 格式 開頭字母 第一碼1或2 後8碼數字

		List<PersonInfo> list = new ArrayList<>();

		// 錯誤
		// id為空
		list.add(new PersonInfo("", "negi", 23, "taich"));
		List<PersonInfo> result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error1");

		// 開頭錯
		list.add(new PersonInfo("1123456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error2");

		// 第一碼錯
		list.add(new PersonInfo("A823456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error3");

		// 未到8碼
		list.add(new PersonInfo("A12345678", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error4");

		// 超過8碼
		list.add(new PersonInfo("A12345678910", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error5");

		// 新增一個
		list.add(new PersonInfo("A123456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);

		// 重複存在
		list.add(new PersonInfo("A123456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error6");
		list = new ArrayList<>();
		personInfoDao.deleteAll();

		// 正常新增多筆
		list.add(new PersonInfo("F223456789", "BBB", 24, "Barea"));
		list.add(new PersonInfo("D122345678", "DDD", 26, "Darea"));
		list.add(new PersonInfo("B122345678", "AAA", 23, "Aarea"));
		list.add(new PersonInfo("E223456789", "EEE", 27, "Earea"));
		list.add(new PersonInfo("A123456789", "FFF", 28, "Farea"));
		list.add(new PersonInfo("C123456789", "CCC", 25, "Carea"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result != null, "error0");

	}

	@Test
	public void findAllTest() {
		// 資料庫裡有資料
		List<PersonInfo> result = personInfoService.findAll();
		Assert.isTrue(result != null, "error");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}

	@Test
	public void findByIdTest() {
		// id為空 null 找不到id
		PersonInfo result = personInfoService.findById("");
		Assert.isTrue(result == null, "error1");
		// id null
		result = personInfoService.findById(null);
		Assert.isTrue(result == null, "error2");
		//找不到
		result = personInfoService.findById("Q122543241");
		Assert.isTrue(result == null, "error3");
		//正常
		result = personInfoService.findById("A123456789");
		Assert.isTrue(result != null, "error4");
		System.out.println(
				result.getId() + " : " + result.getName() + " : " + result.getAge() + " : " + result.getCity());
	}

	@Test
	public void findByAgeGreaterThanTest() {
		// 未輸入(輸入為0)
		List<PersonInfo> result = personInfoService.findByAgeGreaterThan(0);
		Assert.isTrue(result == null, "error1");
		//正常
		result = personInfoService.findByAgeGreaterThan(25);
		Assert.isTrue(result != null, "error2");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}

	@Test
	public void findByAgeLessThanEqualTest() {
		// 未輸入(輸入為0)
		List<PersonInfo> result = personInfoService.findByAgeLess(0);
		Assert.isTrue(result == null, "error1");
		//正常
		result = personInfoService.findByAgeLess(25);
		Assert.isTrue(result != null, "error2");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}

	@Test
	public void findByAgeNotBtwTest() {
		// 2數未輸入(輸入為0)
		List<PersonInfo> result = personInfoService.findByAgeNotBtw(0,0);
		Assert.isTrue(result == null, "error1");
		// 第一個為0
		result = personInfoService.findByAgeNotBtw(25,0);
		Assert.isTrue(result == null, "error2");
		// 第二個為0
		result = personInfoService.findByAgeNotBtw(0,25);
		Assert.isTrue(result == null, "error3");
		// 正常
		result = personInfoService.findByAgeNotBtw(25,26);
		Assert.isTrue(result != null, "error4");
//		System.out.println("1");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	@Test
	public void findByAgeBtwTest() {
		// 2數為0
		List<PersonInfo> result = personInfoService.findByAgeBtw(0,0);
		Assert.isTrue(result == null, "error1");
		// 第一為0
		result = personInfoService.findByAgeBtw(25,0);
		Assert.isTrue(result == null, "error2");
		// 第二為0
		result = personInfoService.findByAgeBtw(0,25);
		Assert.isTrue(result == null, "error3");
		// 正常
		result = personInfoService.findByAgeBtw(24,27);
		Assert.isTrue(result != null, "error4");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	@Test
	public void findByCityTest() {
		//輸入為空
		List<PersonInfo> result = personInfoService.findByCity("");
		Assert.isTrue(result == null,"error1");
		//正常
		result = personInfoService.findByCity("a");
		Assert.isTrue(result != null,"error2");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	@Test
	public void findByAgeCityTest() {
		// 字串為空null
		List<PersonInfo> result = personInfoService.findByAgeCity(null,25);
		Assert.isTrue(result == null,"error1");
		// 年齡為0
		result = personInfoService.findByAgeCity("a",0);
		Assert.isTrue(result == null,"error2");
		// 正常
		result = personInfoService.findByAgeCity("a",25);
		Assert.isTrue(result != null,"error3");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	
	
	@Test
	public void findByBtwTest() {
		// 字串為空null
		List<PersonInfo> result = personInfoDao.findByAgeBetween(23,25);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	
	
	
}