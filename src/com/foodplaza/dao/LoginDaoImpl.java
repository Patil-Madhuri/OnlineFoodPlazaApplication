package com.foodplaza.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodPlaza.Pojo.Login;
import com.foodplaza.utility.DButility;

public class LoginDaoImpl implements LoginDao
{

	Connection con;
	PreparedStatement ps;
	Login l = new Login();
	@Override
	public boolean loginCust(String un, String pwd) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select custemailid,custpassword from customer_20479 where custemailid=? and custpassword=?");
			ps.setString(1, un);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
				
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean loginAdmin(String un, String pwd) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select email,password from admin_20479 where email=? and password=?");
			ps.setString(1,un);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updatePwdCust(String un, String oldpwd, String newpwd) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("update customer_20479 set custpassword=? where custemailid=? and custpassword=?");
			ps.setString(1, newpwd);
			ps.setString(2, un);
			ps.setString(3, oldpwd);
			int x = ps.executeUpdate();
			if(x > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updatePwdAdmin(String un, String oldpwd, String newpwd) 
	{		
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("update admin_20479 set password=? where email=? and password=?");
			ps.setString(1, newpwd);
			ps.setString(2, un);
			ps.setString(3, oldpwd);
			int x = ps.executeUpdate();
			if(x > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
