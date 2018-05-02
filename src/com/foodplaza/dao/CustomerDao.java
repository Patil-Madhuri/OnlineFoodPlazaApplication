package com.foodplaza.dao;

import java.util.List;


import com.foodPlaza.Pojo.Customer;

public interface CustomerDao 
{
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int id);
	List<Customer> getall();
	Customer getById(int id);
	boolean changePassword(String un,String oldpwd,String newpwd);

}
