package com.foodplaza.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.Pojo.Food;
import com.foodplaza.dao.CustomerDaoImpl;

public class CustomerTest 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int ch=0,cid;
		String cname,cadd,cpass = null;
		long cphone;
		boolean flag;
		
		Customer c = new Customer();
		CustomerDaoImpl cdao = new CustomerDaoImpl();
		
		do
		{
			System.out.println("1.Add Customer \n2.Update Customer \n3.Search Customer \n4.Delete Customer \n5.Display All Customer \n6.Change Password \n7.Exit");
			System.out.println("Enter your Choice");
			ch = s.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Add Customer");
				System.out.println("Enter Customer name: ");
				cname = s.next();
				c.setCustname(cname);
				System.out.println("Enter Customer address: ");
				cadd = s.next();
				c.setAddress(cadd);
				System.out.println("Enter Customer phone: ");
				cphone = s.nextLong();
				c.setCustphone(cphone);
				System.out.println("Enter Customer password: ");
				cpass = s.next();
				c.setPassword(cpass);
				flag = cdao.addCustomer(c);
				
				if(flag)
				{
					System.out.println("Customer added successfully");
				}
				else
				{
					System.out.println("Failed to add Customer");
				}
				break;
			case 2:
				System.out.println("Update Customer");
				System.out.println("Enter the customer id which you want to update");
				cid = s.nextInt();
				c.setCustid(cid);
				if(cid == c.getCustid())
				{
					System.out.println("Enter Customer name: ");
					cname = s.next();
					c.setCustname(cname);
					System.out.println("Enter Customer address: ");
					cadd = s.next();
					c.setAddress(cadd);
					System.out.println("Enter Customer phone: ");
					cphone = s.nextLong();
					c.setCustphone(cphone);
					/*System.out.println("Enter Customer password: ");
					cpass = s.next();
					c.setPassword(cpass);*/
					flag = cdao.updateCustomer(c);
					if(flag)
					{
						System.out.println("Customer updated successfully");
					}
					else
					{
						System.out.println("Failed to update Customer");
					}
				}
				break;
			case 3:
				System.out.println("Search Customer");
				System.out.println("Enter the customer id which you want to search");
				cid = s.nextInt();
				
				c = cdao.getById(cid);
				System.out.println(c);
				break;
			case 4:
				System.out.println("Delete Customer");
				System.out.println("Enter the customer id which you want to delete: ");
				cid = s.nextInt();
				
				flag = cdao.deleteCustomer(cid);
				if(flag)
				{
					System.out.println("customer deleted.....");
				}
				else
				{
					System.out.println("customer not deleted");
				}
				break;
				
			case 5:
				System.out.println("Display All Customer");
				List<Customer> l = cdao.getall();
				
				Iterator<Customer> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				break;
			case 6:
				System.out.println("Change Password");
				System.out.println("Enter username:");
				cname = s.next();
				System.out.println("Enter old password:");
				String oldpwd = s.next();
				System.out.println("Enter new password: ");
				String newpwd = s.next();
				System.out.println("Retype password: ");
				String cpwd = s.next();
				
				if(newpwd.equals(cpwd))
				{
					
					flag = cdao.changePassword(cname, oldpwd, newpwd);
					if(flag)
					{
						System.out.println("password changed");
					}
					else
					{
						System.out.println("password not changed");
					}
					
				}
				break;
			case 7:
				System.out.println("Thanks...Visit Again...");
				System.exit(0);
				default:
					System.out.println("Invalid Choice");
			}
			
		}while(ch > 0);
		
	}
}
