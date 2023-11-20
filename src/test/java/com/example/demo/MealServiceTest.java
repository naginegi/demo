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
		// ��PK���p �u��2��PK�ۦP�~�|�����P�@�ӪF��
		// �W�� �N�k�� ���� �s�b
		
		//�W��
		Meal result = mealService.addMeal(new Meal("", "fire", 100));
		Assert.isTrue(result == null, "error1");
		//�N�k��
		result = mealService.addMeal(new Meal("pork", "", 100));
		Assert.isTrue(result == null, "error2");
		//����
		result = mealService.addMeal(new Meal("pork", "fire", 0));
		Assert.isTrue(result == null, "error3");
		//���`
		result = mealService.addMeal(new Meal("pork", "fire", 100));
		Assert.isTrue(result != null, "error4");
		// �W���� �i�s
		result = mealService.addMeal(new Meal("pork", "BBQ", 100));
		Assert.isTrue(result != null, "error5");
		// �N�k���� �i�s
		result = mealService.addMeal(new Meal("beef", "fire", 100));
		Assert.isTrue(result != null, "error6");
		// �W�N�k���� ���i
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
		//����j�p
		//�j��GGreaterThan
		//�j�󵥩�GGreaterThanEqual
		//�p��GLessThan
		//�p�󵥩�GLessThanEquals
		
		List<Meal> res = mealDao.findByPriceGreaterThanOrderByPrice(200);
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void compareTest1() {	
		//��X�j��200����chicken
		List<Meal> res = mealDao.findByNameAndPriceGreaterThanOrderByPrice("chicken", 200);
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void containingsTest() {
		//�]�t(Containing) �j�M
		//��Xname �̦�"e"�����
		List<Meal> res = mealDao.findByNameContaining("e");
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}
	
	@Test
	public void containingsTest1() {
		//�]�t(Containing) �j�M
		//��Xname �̦�"b"����Ƥ�cookingstyle �̦�"b"�����
		List<Meal> res = mealDao.findByNameContainingAndCookingStyleContaining("b", "b");
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
	}

	@Test
	public void betweenTest() {
		//��Xprice 120~260(���]�t�W�U��) �������
		List<Meal> res = mealDao.findByPriceBetweenOrderByPrice(120, 260);
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
		
	}
	
	@Test
	public void inTest() {
		// in ��X��Ʈw�̦��S���o�ǪF��
		// ��X����O120,150,180,200�����
		List<Meal> res = mealDao.findByPriceIn(new ArrayList<>(List.of(120,150,180,200)));
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}
		
	}
	
	@Test
	public void notInTest() {
		// NotIn ��X��Ʈw�̳o�ǥH�~���F��
		// ��X����O120,150,180,200 �H�~�����
		List<Meal> res = mealDao.findByPriceNotIn(new ArrayList<>(List.of(120,150,180,200)));
		for(Meal item:res) {
			System.out.println(item.getName()+":"+item.getCookingStyle()
			+":"+item.getPrice());
		}	
	}
}