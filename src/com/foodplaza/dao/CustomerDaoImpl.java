package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.Pojo.Food;
import com.foodplaza.utility.DButility;

public class CustomerDaoImpl implements CustomerDao
{
	Customer c = new Customer();
	PreparedStatement ps;
	Connection con;
	
	@Override
	public boolean addCustomer(Customer c) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("insert into customer_20479(custname,custadd,custphone, custemailid, custpassword) values (?,?,?,?,?)");
			ps.setString(1,c.getCustname() );
			ps.setString(2, c.getAddress());
			ps.setLong(3, c.getCustphone());
			ps.setString(4, c.getCustemail());
			ps.setString(5, c.getPassword());
			
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
	public boolean updateCustomer(Customer c)
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("update customer_20479 set custname=?,custadd=?,custphone=?, custemailid=? where custid=?");
			ps.setString(1, c.getCustname());
			ps.setString(2, c.getAddress());
			ps.setLong(3, c.getCustphone());
		//	ps.setString(4,c.getPassword());
			ps.setString(4, c.getCustemail());
			ps.setInt(5, c.getCustid());
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
	public boolean deleteCustomer(int id) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("delete from customer_20479 where custid=?");
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
	public List<Customer> getall() 
	{
		List <Customer> list=new LinkedList<>();
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select * from customer_20479");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustid(rs.getInt("custid"));
				c.setCustname(rs.getString("custname"));
				c.setAddress(rs.getString("custadd"));
				c.setCustphone(rs.getLong("custphone"));
				c.setCustemail(rs.getString("custemailid" ));
				//c.setPassword(rs.getString("custpassword"));
				list.add(c);
				
			}
			//System.out.println(list);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer getById(int id) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select * from customer_20479 where custid = ?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				c.setCustid(rs.getInt("custid"));
				c.setCustname(rs.getString("custname"));
				c.setAddress(rs.getString("custadd"));
				c.setCustphone(rs.getLong("custphone"));
				c.setCustemail(rs.getString( "custemailid" ));
				c.setPassword(rs.getString("custpassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	@Override
	public Customer getByEmail(String email) 
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select * from customer_20479 where custemailid= ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				c.setCustid(rs.getInt("custid"));
				c.setCustname(rs.getString("custname"));
				c.setAddress(rs.getString("custadd"));
				c.setCustphone(rs.getLong("custphone"));
				c.setCustemail(rs.getString( "custemailid" ));
				c.setPassword(rs.getString("custpassword"));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public boolean changePassword(String un, String oldpwd, String newpwd) 
	{
		con = DButility.getconnection();
		try {
		ps = con.prepareStatement("update customer_20479 set custpassword=? where custname=? and custpassword=?");
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
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

}
