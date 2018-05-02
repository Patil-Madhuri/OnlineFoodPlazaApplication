package com.foodplaza.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.foodPlaza.Pojo.Food;
import com.foodplaza.dao.FoodDaoImpl;

public class FoodTest
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int ch=0;
		String fname,fcat;
		double fprice;
		boolean flag;
		int fid;
		
		Food f = new Food();
		FoodDaoImpl fdao = new FoodDaoImpl();
		do
		{
		System.out.println("1.Add Food \n2.Update Food \n3.Search Food \n4.Delete Food \n5.Display All \n6.Exit");
		System.out.println("Enter your Choice");
		ch = s.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Add Food");
			System.out.println("Enter food name: ");
			fname = s.next();
			f.setFood_name(fname);
			System.out.println("Enter food category: ");
			fcat = s.next();
			f.setFood_category(fcat);
			System.out.println("Enter food price: ");
			fprice = s.nextDouble();
			f.setFood_price(fprice);
			
			flag = fdao.addFood(f);
			if(flag)
			{
				System.out.println("Food added successfully");
			}
			else
			{
				System.out.println("Failed to add food");
			}
			break;
		case 2:
			System.out.println("Update Food");
			System.out.println("Enter the food id which you want to update");
			fid = s.nextInt();
			f.setFood_id(fid);
			if(fid == f.getFood_id())
			{
				System.out.println("Enter food name: ");
				fname = s.next();
				f.setFood_name(fname);
				System.out.println("Enter food category: ");
				fcat = s.next();
				f.setFood_category(fcat);
				System.out.println("Enter food price: ");
				fprice = s.nextDouble();
				f.setFood_price(fprice);
				 flag = fdao.updateFood(f);
				 
			}
			
			break;
		case 3:
			System.out.println("Search Food");
			System.out.println("Enter the food id which you want to search");
			fid = s.nextInt();
			
			

			    f = fdao.getById(fid);
			    System.out.println(f);
			    
		
			break;
		case 4:
			System.out.println("Delete Food");
			System.out.println("Enter the food id which you want to delete: ");
			fid = s.nextInt();
			flag = fdao.deleteFood(fid);
			if(flag)
			{
				System.out.println("food deleted.....");
			}
			else
			{
				System.out.println("not deleted");
			}		
			
			
			break;
		case 5:
			System.out.println("Display All");
			List<Food> l = fdao.getall();
			
			Iterator<Food> itr = l.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			
			break;
		case 6: 
			System.out.println("Thanks..Visit Again..");
			System.exit(0);
		default:
			System.out.println("Invalid choice");
				
		}
		}while(ch>0);
		s.close();
	}
}
