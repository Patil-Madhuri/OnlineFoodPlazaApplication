package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import com.foodPlaza.Pojo.Cart;
import com.foodplaza.utility.DButility;

public class CartDaoImpl implements CartDao
{

	Cart c = new Cart();
	PreparedStatement ps;
	Connection con;
	@Override
	public boolean addTocart(Cart c) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select foodname,foodprice from food_20479 where foodid= ?");
			ps.setInt(1, c.getFoodid());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				c.setFoodprice(rs.getDouble("foodprice"));
				c.setFoodname(rs.getString("foodname"));
			}
			
			ps = con.prepareStatement("insert into cart_20479(foodid,custemailid,quantity,foodprice,foodname) values(?,?,?,?,?)");
			ps.setInt(1, c.getFoodid());
			ps.setString(2, c.getCustemailid());
			ps.setInt(3, c.getQuantity());
			ps.setDouble(4, c.getFoodprice());
			ps.setString(5, c.getFoodname());
			
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
	public boolean deletecart(int id) {
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("delete from cart_20479 where cart_id=?");
			ps.setInt(1, id);
			int x=ps.executeUpdate();
			if(x>0)
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
	public List<Cart> showcart(String un) 
	{
		List<Cart> list = new LinkedList<>();
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select * from cart_20479 where custemailid= ?");
			ps.setString(1, un);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Cart c = new Cart();
				c.setCartid(rs.getInt("cart_id"));
				c.setFoodid(rs.getInt("foodid"));
				c.setFoodprice(rs.getDouble("foodprice"));
				c.setFoodname(rs.getString("foodname"));
				c.setCustemailid(rs.getString("custemailid"));
				c.setQuantity(rs.getInt("quantity"));
				list.add(c);
			}
			//return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}
