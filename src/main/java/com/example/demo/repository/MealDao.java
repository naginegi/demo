package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Meal;
import com.example.demo.entity.MealId;

@Repository
public interface MealDao extends JpaRepository<Meal, MealId>{

	// 限制搜尋結果回傳的筆數
	// 限制回傳筆數是3筆
	// Top First 寫法意思一樣
	// 資料型態為list 因為會回傳多筆資料
	// 所以需要參數 String name
	public List<Meal> findTop2ByName(String name);
	public List<Meal> findFirst2ByName(String name);
	
	//排序
	//預設按ASC：由小到大 。 另Desc：由大到小 
	public List<Meal> findAllByOrderByPrice();
	
	//
	public List<Meal> findByNameOrderByPriceDesc(String name);
	
	//比較大小
	//大於：GreaterThan
	//大於等於：GreaterThanEqual
	//小於：LessThan
	//小於等於：LessThanEqual
	public List<Meal> findByPriceGreaterThanOrderByPrice(int price);
	
	// 找名子 而且 價錢大於 由小到大排
	public List<Meal> findByNameAndPriceGreaterThanOrderByPrice(String name , int price);
	
	//containing
	public List<Meal> findByNameContaining(String name);
	
	//containing
	public List<Meal> findByNameContainingAndCookingStyleContaining(String name,String cookingStyle);
	
	//between
	public List<Meal> findByPriceBetween(int price1,int price2);
	//排序
	public List<Meal> findByPriceBetweenOrderByPrice(int price1,int price2);
	
	//in
	public List<Meal> findByPriceIn(List<Integer> priceList);
	//notin
	public List<Meal> findByPriceNotIn(List<Integer> priceList);
		
}


//@Repository  //託管
//public interface MenuDao extends JpaRepository<Menu, String>{
//	
//}