package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.foodPlaza.Pojo.Order;
import com.foodplaza.utility.DButility;

public class OrderDaoImpl implements  OrderDao
{
	Connection con;
	PreparedStatement ps;
	Order o = new Order();
	@Override
	public boolean placeorder(String custemailid) 
	{
		double totalbill = 0;
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select sum(foodprice * quantity) as totalbill from cart_20479 where custemailid=?");
			ps.setString(1, custemailid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				totalbill=rs.getDouble("totalbill");
			}
			
			ps = con.prepareStatement("insert into order_20479 (custemailid,totalbill,status,date) values(?,?,?,sysdate())");
			ps.setString(1, custemailid);
			ps.setDouble(2, totalbill);
			ps.setString(3, "processing");
			
			int x = ps.executeUpdate();
			if(x > 0)
			{
				ps = con.prepareStatement("delete from cart_20479 where custemailid=?");
				ps.setString(1, custemailid);
				int y = ps.executeUpdate();
				if(y > 0)
				{
					return true;
				}
				else
				{
					return false;
				}
				
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
	public boolean deleteorder(int id) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("delete from order_20479 where orderid=?");
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
	public List<Order> showorder() 
	{
		List<Order> list = new LinkedList<>();
		con = DButility.getconnection();
		try {
		ps = con.prepareStatement("select * from order_20479");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Order o = new Order();
			o.setOrderid(rs.getInt("orderid"));
			o.setCustemailid(rs.getString("custemailid"));
			o.setTotalbill(rs.getDouble("totalbill"));
			o.setDate(rs.getString("date"));
			o.setStatus(rs.getString("status"));
			list.add(o);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
