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
		// �̭���List
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("A123147852", "negi", 23, "taiah"));
		list.add(new PersonInfo("E177777777", "negi", 23, "taiah"));
		personInfoDao.saveAll(list);
	}

	@Test
	public void daoAllTest2() {
		// �̭���List
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
		// ��Id�䪺�g�k
		Optional<PersonInfo> infoOp = personInfoDao.findById("E222222222");
		if (infoOp.isEmpty()) {
			System.out.println("Not found");// �䤣��Nnot found
		} else {
			System.out.println(infoOp.get().getName());// ���ҳ\ID��name
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
		// �۩w�q��k�A��city
		List<PersonInfo> result = personInfoDao.findByCity("taich");
		List<PersonInfo> result1 = personInfoDao.findByNameAndCity(null, null);
		for (PersonInfo item : result) {
			System.out.println(item.getName());
		}
	}

	@Test
	public void daoExistsTest() {
		// exists ��X�����L��
		System.out.println(personInfoDao.existsById("A123456789"));// true
		// findbyid ���X�ӬO��ơA�Φb����ݭn�ާ@���a��
		// existsbyid ��§P�_��Ʀs���s�b �ҡG���P�ӱb�����U
	}

	@Test
	public void addInfoTest() {
		// �榡 null ����
		// �榡 �}�Y�r�� �Ĥ@�X1��2 ��8�X�Ʀr

		List<PersonInfo> list = new ArrayList<>();

		// ���~
		// id����
		list.add(new PersonInfo("", "negi", 23, "taich"));
		List<PersonInfo> result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error1");

		// �}�Y��
		list.add(new PersonInfo("1123456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error2");

		// �Ĥ@�X��
		list.add(new PersonInfo("A823456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error3");

		// ����8�X
		list.add(new PersonInfo("A12345678", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error4");

		// �W�L8�X
		list.add(new PersonInfo("A12345678910", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error5");

		// �s�W�@��
		list.add(new PersonInfo("A123456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);

		// ���Ʀs�b
		list.add(new PersonInfo("A123456789", "negi", 23, "taich"));
		result = personInfoService.addInfoList1(list);
		Assert.isTrue(result == null, "error6");
		list = new ArrayList<>();
		personInfoDao.deleteAll();

		// ���`�s�W�h��
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
		// ��Ʈw�̦����
		List<PersonInfo> result = personInfoService.findAll();
		Assert.isTrue(result != null, "error");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}

	@Test
	public void findByIdTest() {
		// id���� null �䤣��id
		PersonInfo result = personInfoService.findById("");
		Assert.isTrue(result == null, "error1");
		// id null
		result = personInfoService.findById(null);
		Assert.isTrue(result == null, "error2");
		//�䤣��
		result = personInfoService.findById("Q122543241");
		Assert.isTrue(result == null, "error3");
		//���`
		result = personInfoService.findById("A123456789");
		Assert.isTrue(result != null, "error4");
		System.out.println(
				result.getId() + " : " + result.getName() + " : " + result.getAge() + " : " + result.getCity());
	}

	@Test
	public void findByAgeGreaterThanTest() {
		// ����J(��J��0)
		List<PersonInfo> result = personInfoService.findByAgeGreaterThan(0);
		Assert.isTrue(result == null, "error1");
		//���`
		result = personInfoService.findByAgeGreaterThan(25);
		Assert.isTrue(result != null, "error2");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}

	@Test
	public void findByAgeLessThanEqualTest() {
		// ����J(��J��0)
		List<PersonInfo> result = personInfoService.findByAgeLess(0);
		Assert.isTrue(result == null, "error1");
		//���`
		result = personInfoService.findByAgeLess(25);
		Assert.isTrue(result != null, "error2");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}

	@Test
	public void findByAgeNotBtwTest() {
		// 2�ƥ���J(��J��0)
		List<PersonInfo> result = personInfoService.findByAgeNotBtw(0,0);
		Assert.isTrue(result == null, "error1");
		// �Ĥ@�Ӭ�0
		result = personInfoService.findByAgeNotBtw(25,0);
		Assert.isTrue(result == null, "error2");
		// �ĤG�Ӭ�0
		result = personInfoService.findByAgeNotBtw(0,25);
		Assert.isTrue(result == null, "error3");
		// ���`
		result = personInfoService.findByAgeNotBtw(25,26);
		Assert.isTrue(result != null, "error4");
//		System.out.println("1");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	@Test
	public void findByAgeBtwTest() {
		// 2�Ƭ�0
		List<PersonInfo> result = personInfoService.findByAgeBtw(0,0);
		Assert.isTrue(result == null, "error1");
		// �Ĥ@��0
		result = personInfoService.findByAgeBtw(25,0);
		Assert.isTrue(result == null, "error2");
		// �ĤG��0
		result = personInfoService.findByAgeBtw(0,25);
		Assert.isTrue(result == null, "error3");
		// ���`
		result = personInfoService.findByAgeBtw(24,27);
		Assert.isTrue(result != null, "error4");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	@Test
	public void findByCityTest() {
		//��J����
		List<PersonInfo> result = personInfoService.findByCity("");
		Assert.isTrue(result == null,"error1");
		//���`
		result = personInfoService.findByCity("a");
		Assert.isTrue(result != null,"error2");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	@Test
	public void findByAgeCityTest() {
		// �r�ꬰ��null
		List<PersonInfo> result = personInfoService.findByAgeCity(null,25);
		Assert.isTrue(result == null,"error1");
		// �~�֬�0
		result = personInfoService.findByAgeCity("a",0);
		Assert.isTrue(result == null,"error2");
		// ���`
		result = personInfoService.findByAgeCity("a",25);
		Assert.isTrue(result != null,"error3");
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	
	
	@Test
	public void findByBtwTest() {
		// �r�ꬰ��null
		List<PersonInfo> result = personInfoDao.findByAgeBetween(23,25);
		for (PersonInfo item : result) {
			System.out.println(item.getId() + " : " + item.getName() + " : " + item.getAge() + " : " + item.getCity());
		}
	}
	
	
	
	
}