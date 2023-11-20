package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addInfo(PersonInfo info) {
		String patter = "[\\w&&[^\\d_]][1,2]\\d{8}";
		if (info.getId() != null && info.getId().matches(patter)) {
//		System.out.println(info.getId());
			personInfoDao.save(info);
			System.out.println("success");
		} else {
			System.out.println("id error");
		}

	}

	// saveAll
	@Override
	public void addInfoList(List<PersonInfo> info) {

		// 先對List裡的資料做檢查，最後在將資料一次saveAll
		// 用foreach做檢查，有錯就直接return跳出方法(有錯就不存)
		// 在程式中能和資料庫互動的次數越少越好，若有多筆資料，用saveAll一次儲存

		String patter = "[\\w&&[^\\d_]][1,2]\\d{8}";
		for (PersonInfo item : info) {
			String id = item.getId();
			if (!(StringUtils.hasText(id) && id.matches(patter))) {
				System.out.println("id error");
				return;
			}
		}
		personInfoDao.saveAll(info);
	}

	
	
	@Override
	public List<PersonInfo> addInfoList1(List<PersonInfo> list) {
		// 格式 null 重複
		String patter = "[\\w&&[^\\d_]][1,2]\\d{8}";
		for (PersonInfo item : list) {
			String id = item.getId();
			if (!(StringUtils.hasText(id) && id.matches(patter))) {
				System.out.println("id error");
				return null;
			}
			if (personInfoDao.existsById(id)) {
				return null;
			}
			System.out.println(item.getId() + ":" + item.getName() + ":" + item.getAge() + ":" + item.getCity());
		}
		return personInfoDao.saveAll(list);
	}

	@Override
	public List<PersonInfo> findAll() {
		if (personInfoDao.findAll().size() == 0) {
			return null;
		}
		return personInfoDao.findAll();
	}

	@Override
	public PersonInfo findById(String id) {
		if (StringUtils.hasText(id) && personInfoDao.existsById(id)) {
			Optional<PersonInfo> op = personInfoDao.findById(id);
			return op.get();
		}
		return null;
	}

	@Override
	public List<PersonInfo> findByAgeGreaterThan(int age) {
		if (age != 0) {
			return personInfoDao.findByAgeGreaterThan(age);
		}
		return null;
	}

	@Override
	public List<PersonInfo> findByAgeLess(int age) {
		if (age != 0) {
			return personInfoDao.findByAgeLessThanEqualOrderByAge(age);
		}
		return null;
	}

	@Override
	public List<PersonInfo> findByAgeNotBtw(int age1, int age2) {
		if (age1 > 0 && age2 > 0) {
			return personInfoDao.findByAgeLessThanOrAgeGreaterThan(age1, age2);
		}
		return null;
	}

	@Override
	public List<PersonInfo> findByAgeBtw(int age1, int age2) {
		if (age1 > 0 && age2 > 0) {
			return personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(age1, age2);
		}
		return null;
	}

	@Override
	public List<PersonInfo> findByCity(String city) {
		if (StringUtils.hasText(city)) {
			return personInfoDao.findByCityContaining(city);
		}
		return null;

	}

	@Override
	public List<PersonInfo> findByAgeCity(String city, int age) {
		if (StringUtils.hasText(city) && age > 0) {
			return personInfoDao.findByCityContainingAndAgeGreaterThanOrderByAgeDesc(city, age);
		}
		return null;
	}

}
