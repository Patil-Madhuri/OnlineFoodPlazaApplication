package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.foodPlaza.Pojo.Food;
import com.foodplaza.utility.DButility;

public class FoodDaoImpl implements FoodDao
{
	Food f=new Food();
	PreparedStatement ps;
	
	Connection con;
	@Override
	public boolean addFood(Food f) 
	{
		
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("insert into food_20479(foodname,foodprice,foodcategory)values(?,?,?)");
			ps.setString(1,f.getFood_name() );
			ps.setDouble(2,f.getFood_price() );
			ps.setString(3, f.getFood_category());
			
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
	public boolean updateFood(Food f) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("update food_20479 set foodname=?,foodprice=?,foodcategory=? where foodid=?");
			ps.setString(1,f.getFood_name());
			ps.setDouble(2,f.getFood_price());
			ps.setString(3, f.getFood_category());
			ps.setInt(4,f.getFood_id());
			
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
	public boolean deleteFood(int id)
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("delete from food_20479 where foodid=?");
			ps.setInt(1,id);
			
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
	public List<Food> getall() 
	{
		List <Food> list=new LinkedList<>();
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select * from food_20479");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Food f=new Food();
				f.setFood_id(rs.getInt("foodid"));
				f.setFood_name(rs.getString("foodname"));
				f.setFood_price(rs.getDouble("foodprice"));
				f.setFood_category(rs.getString("foodcategory"));
				list.add(f);
				
			}
			return list;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Food getById(int id) 
	{
		con = DButility.getconnection();
		try
		{
			ps = con.prepareStatement("select *from  food_20479 where foodid=?");
			ps.setInt(1, id);
			
			//System.out.println(f);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				f.setFood_id(rs.getInt("foodid"));
				f.setFood_name(rs.getString("foodname"));
				f.setFood_price(rs.getDouble("foodprice"));
				f.setFood_category(rs.getString("foodcategory"));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return f;
	}

}
