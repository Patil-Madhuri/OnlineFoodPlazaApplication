package com.foodplaza.dao;

import java.util.List;

import com.foodPlaza.Pojo.Cart;

public interface CartDao
{
	boolean addTocart(Cart c);
	boolean deletecart(int id);
	List<Cart> showcart(String un);
}
