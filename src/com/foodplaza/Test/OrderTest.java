package com.foodplaza.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.foodPlaza.Pojo.Order;
import com.foodplaza.dao.OrderDaoImpl;

public class OrderTest
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int oid,ch=0;
		String custemailid,status,date;
		
		boolean flag;
		Order o = new Order();
		OrderDaoImpl odao = new OrderDaoImpl();
		
		do
		{
			System.out.println("1.Place Order \n2.Delete Order \n3.Show Order \n4.Exit");
			System.out.println("Enter your choice");
			ch = s.nextInt();
			switch(ch)
			{
			case 1:			//place order
				System.out.println("Enter customer email id: ");
				custemailid = s.next();
				
				flag = odao.placeorder(custemailid);
				if(flag)
				{
					System.out.println("Successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
				
			case 2:			//delete order
				System.out.println("Enter order id: ");
				 oid = s.nextInt();
				flag = odao.deleteorder(oid);
				if(flag)
				{
					System.out.println("Successfully");
				}
				else
				{
					System.out.println("Failed");
				}
				break;
			case 3:			//show order
				List<Order> l = odao.showorder();
				Iterator< Order> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				break;
			case 4:
				System.out.println("Thanks....Visit Again...");
				System.exit(0);
				default:
					System.out.println("Invalid Choice");
			}
		}while(ch > 0);
		s.close();
	}
}
