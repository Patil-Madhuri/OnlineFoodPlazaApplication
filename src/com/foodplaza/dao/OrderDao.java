package com.foodplaza.dao;

import java.util.List;

import com.foodPlaza.Pojo.Order;

public interface OrderDao
{
	boolean placeorder(String custemailid);
	boolean deleteorder(int id);
	List <Order> showorder();
}
