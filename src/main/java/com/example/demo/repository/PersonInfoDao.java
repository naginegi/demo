package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository 
public interface PersonInfoDao extends JpaRepository<PersonInfo, String>{
	
	//自定義方法 findBy"City"指的是entity裡屬性city的名稱，必須2個相同
	//findByCity是固定寫法
	//希望回傳多筆資料，用List接
	//             多條件查詢  findByNameAndCity 
	public List<PersonInfo> findByCity(String city);
	
	public List<PersonInfo> findByNameAndCity(String name , String city);
	
	
	//大於輸入條件
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	//小於等於輸入條件
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);
	
	//在輸入條件外 //findByAgeLessThanOrAgeGreaterThan
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1,int age2);
	
	//在輸入條件內
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1,int age2);
	
	//找city+特定字
	public List<PersonInfo> findByCityContaining(String city);
	
	//年紀大於輸入條件&&找city+特定字
	public List<PersonInfo> findByCityContainingAndAgeGreaterThanOrderByAgeDesc(String city,int age);
	
	//not btw
	public List<PersonInfo> findByAgeBetween(int a,int b);	
	
	
}
