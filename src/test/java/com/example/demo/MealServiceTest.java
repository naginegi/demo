package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.Meal;
import com.example.demo.repository.MealDao;
import com.example.demo.service.ifs.MealService;

@SpringBootTest
public class MealServiceTest {

	@Autowired
	private MealService mealService;
	
	@Autowired
	private MealDao mealDao;

	@Test
	public void addMealTest() {
		// 雙PK情況 只有2個PK相同才會視為同一個東西
		// 名錯 煮法錯 錢錯 存在
		
		//名錯
		Meal result = mealService.addMeal(new Meal("", "fire", 100));
		Assert.isTrue(result == null, "error1");
		//煮法錯
		result = mealService.addMeal(new Meal("pork", "", 100));
		Assert.isTrue(result == null, "error2");
		//錢錯
		result = mealService.addMeal(new Meal("pork", "fire", 0));
		Assert.isTrue(result == null, "error3");
		//正常
		result = mealService.addMeal(new Meal("pork", "fire", 100));
		Assert.isTrue(result != null, "error4");
		// 名重複 可存
		result = mealService.addMeal(new Meal("pork", "BBQ", 100));
		Assert.isTrue(result != null, "error5");
		// 煮法重複 可存
		result = mealService.addMeal(new Meal("beef", "fire", 100));
		Assert.isTrue(result != null, "error6");
		// 名煮法重複 不可
		result = mealService.addMeal(new Meal("pork", "fire", 100));
		Assert.isTrue(result == null, "error7");
	}
	
	@Test
	public void addMeal() {
		mealService.addMeal(new Meal("beef","BBQ",180));
		mealService.addMeal(new Meal("beef","fry",150));
		mealService.addMeal(new Meal("pork","fried",220));
		mealService.addMeal(new Meal("chicken","stew",260));
		mealService.addMeal(new Meal("chicken","BBQ",120));
		mealService.addMeal(new Meal("chicken","steam",520));
	}
	
	@Test
	public void limitMealTest() {
		List<Meal> res = mealDao.findFirst2ByName("chicken");
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()+":"+item.getPrice());
		}
		
//		System.out.println(res.size());
		Assert.isTrue(res.size() == 2 ,"error");
	}

	
	@Test
	public void orderByMealTest() {
		List<Meal> res = mealDao.findAllByOrderByPrice();
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void orderByMealTest1() {
		List<Meal> res = mealDao.findByNameOrderByPriceDesc("chicken");
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void compareTest() {
		//比較大小
		//大於：GreaterThan
		//大於等於：GreaterThanEqual
		//小於：LessThan
		//小於等於：LessThanEquals
		
		List<Meal> res = mealDao.findByPriceGreaterThanOrderByPrice(200);
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void compareTest1() {	
		//找出大於200塊的chicken
		List<Meal> res = mealDao.findByNameAndPriceGreaterThanOrderByPrice("chicken", 200);
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void containingsTest() {
		//包含(Containing) 搜尋
		//找出name 裡有"e"的資料
		List<Meal> res = mealDao.findByNameContaining("e");
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void containingsTest1() {
		//包含(Containing) 搜尋
		//找出name 裡有"b"的資料及cookingstyle 裡有"b"的資料
		List<Meal> res = mealDao.findByNameContainingAndCookingStyleContaining("b", "b");
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}

	@Test
	public void betweenTest() {
		//找出price 120~260(有包含上下界) 間的資料
		List<Meal> res = mealDao.findByPriceBetweenOrderByPrice(120, 260);
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
		
	}
	
	@Test
	public void inTest() {
		// in 找出資料庫裡有沒有這些東西
		// 找出價格是120,150,180,200的資料
		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(120,150,180,200)));
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
		
	}
	
	@Test
	public void notInTest() {
		// NotIn 找出資料庫裡這些以外的東西
		// 找出價格是120,150,180,200 以外的資料
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(120,150,180,200)));
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}	
	}
}