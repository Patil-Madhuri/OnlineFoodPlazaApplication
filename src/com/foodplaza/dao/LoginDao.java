package com.foodplaza.dao;

public interface LoginDao 
{
	boolean loginCust(String un,String pwd);
	boolean loginAdmin(String un,String pwd);
	boolean updatePwdCust(String un,String oldpwd,String newpwd);
	boolean updatePwdAdmin(String un,String oldpwd,String newpwd);
}
