package com.example.demo.service.ifs;

import com.example.demo.entity.Meal;

public interface MealService {
	
	public Meal addMeal(Meal mael);
	
	public Meal findByName(String name);
	
}
