package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId>{

	// ����j�M���G�^�Ǫ�����
	// ����^�ǵ��ƬO3��
	// Top First �g�k�N��@��
	// ��ƫ��A��list �]���|�^�Ǧh�����
	// �ҥH�ݭn�Ѽ� String name
	public List<Meal> findTop2ByName(String name);
	public List<Meal> findFirst2ByName(String name);
	
	//�Ƨ�
	//�w�]��ASC�G�Ѥp��j �C �tDesc�G�Ѥj��p 
	public List<Meal> findAllByOrderByPrice();
	
	//
	public List<Meal> findByNameOrderByPriceDesc(String name);
	
	//����j�p
	//�j��GGreaterThan
	//�j�󵥩�GGreaterThanEqual
	//�p��GLessThan
	//�p�󵥩�GLessThanEqual
	public List<Meal> findByPriceGreaterThanOrderByPrice(int price);
	
	// ��W�l �ӥB �����j�� �Ѥp��j��
	public List<Meal> findByNameAndPriceGreaterThanOrderByPrice(String name , int price);
	
	//containing
	public List<Meal> findByNameContaining(String name);
	
	//containing
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name,String cookingStyle);
	
	//between
	public List<Meal> findByPriceBetween(int price1,int price2);
	//�Ƨ�
	public List<Meal> findByPriceBetweenOrderByPrice(int price1,int price2);
	
	//in
	public List<Meal> findByPriceIn(List<Integer> priceList);
	//notin
	public List<Meal> findByPriceNotIn(List<Integer> priceList);
		
}


//@Repository  //�U��
//public interface MenuDao extends JpaRepository<Menu, String>{
//	
//}