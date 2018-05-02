package com.foodplaza.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.foodPlaza.Pojo.Cart;
import com.foodplaza.dao.CartDaoImpl;

public class CartTest 
{
	public static void main(String[] args) 
	{
		
		int ch=0,quantity;
		int fid;
		String custemailid;
		boolean flag;
		Cart c = new Cart();
		CartDaoImpl cdao = new CartDaoImpl();
		Scanner s = new Scanner(System.in);
		do
		{
		System.out.println("1.Add To Cart \n2.Delete from Cart \n3.Show Cart \n4.Exit");
		System.out.println("Enter your choice");
		ch = s.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Add Cart");
			System.out.println("Enter food id");
			fid = s.nextInt();
			c.setFoodid(fid);
			System.out.println("Enter customer username");
			custemailid= s.next();
			c.setCustemailid(custemailid);
			System.out.println("Enter the quantity");
			quantity = s.nextInt();
			c.setQuantity(quantity);
			flag = cdao.addTocart(c);
			if(flag)
			{
				System.out.println("Successfully");
			}
			else
			{
				System.out.println("Failed");
			}
			break;
		case 2:
			System.out.println("Delete Cart");
			System.out.println("enter id u want to delete");
			int cartid=s.nextInt();
			flag = cdao.deletecart(cartid);
			if(flag)
			{
				System.out.println("Successfully deleted");
			}
			else
			{
				System.out.println("Failed");
			}
			
			break;
		case 3:
			System.out.println("Show Cart");
			System.out.println("Enter your username");
			custemailid = s.next();
				List<Cart> l = cdao.showcart(custemailid);
				Iterator< Cart> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
			break;
		case 4:
			System.out.println("Thanks...Visit Again...");
			System.exit(0);
			default:
				System.out.println("Invalid choice");
		}
		}while(ch > 0);
		s.close();
	}
}
