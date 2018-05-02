package com.foodplaza.dao;

import java.util.List;

import com.foodPlaza.Pojo.Food;

public interface FoodDao 
{
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFood(int id);
	List<Food> getall();
	Food getById(int id);
}
