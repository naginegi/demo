package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.PersonInfo;

public interface PersonInfoService {
	
	public void addInfo(PersonInfo info);
	
	public void addInfoList(List<PersonInfo> infoList);
	
	public List<PersonInfo> addInfoList1(List<PersonInfo> list);
	
	public List<PersonInfo> findAll();
	
	public PersonInfo findById(String id);
	
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	public List<PersonInfo> findByAgeLess(int age);
	
	public List<PersonInfo> findByAgeNotBtw(int age1,int age2);
	
	public List<PersonInfo> findByAgeBtw(int age1,int age2);
	
	public List<PersonInfo> findByCity(String city);
	
	public List<PersonInfo> findByAgeCity(String city,int age);
	
}
