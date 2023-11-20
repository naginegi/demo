package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PersonInfo;

@Repository 
public interface PersonInfoDao extends JpaRepository<PersonInfo, String>{
	
	//�۩w�q��k findBy"City"�����Oentity���ݩ�city���W�١A����2�ӬۦP
	//findByCity�O�T�w�g�k
	//�Ʊ�^�Ǧh����ơA��List��
	//             �h����d��  findByNameAndCity 
	public List<PersonInfo> findByCity(String city);
	
	public List<PersonInfo> findByNameAndCity(String name , String city);
	
	
	//�j���J����
	public List<PersonInfo> findByAgeGreaterThan(int age);
	
	//�p�󵥩��J����
	public List<PersonInfo> findByAgeLessThanEqualOrderByAge(int age);
	
	//�b��J����~ //findByAgeLessThanOrAgeGreaterThan
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int age1,int age2);
	
	//�b��J����
	public List<PersonInfo> findTop3ByAgeBetweenOrderByAgeDesc(int age1,int age2);
	
	//��city+�S�w�r
	public List<PersonInfo> findByCityContaining(String city);
	
	//�~���j���J����&&��city+�S�w�r
	public List<PersonInfo> findByCityContainingAndAgeGreaterThanOrderByAgeDesc(String city,int age);
	
	//not btw
	public List<PersonInfo> findByAgeBetween(int a,int b);	
	
	
}
