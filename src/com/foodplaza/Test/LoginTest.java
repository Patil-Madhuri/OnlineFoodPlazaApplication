package com.foodplaza.Test;

import java.util.Scanner;

import com.foodPlaza.Pojo.Login;
import com.foodplaza.dao.LoginDaoImpl;

public class LoginTest
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int ch=0;
		String un,pwd;
		boolean flag;
		Login l = new Login();
		LoginDaoImpl ldao = new LoginDaoImpl();
		do
		{
			System.out.println("1.Customer Login \2.Admin Login \n3.Exit");
			System.out.println("Enter your choice");
			ch = s.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter the username");
				un = s.next();
				l.setUn(un);
				System.out.println("Enter the password");
				pwd = s.next();
				l.setPwd(pwd);
				
				flag = ldao.loginCust(un, pwd);
				if(flag)
				{
					System.out.println("Successfully Login");
				}
				else
				{
					System.out.println("Incorrect password or username");
				}
				break;
			case 2:
				System.out.println("Enter the username");
				un= s.next();
				l.setUn(un);
				System.out.println("Enter the password");
				pwd = s.next();
				l.setPwd(pwd);
				
				flag = ldao.loginAdmin(un, pwd);
				if(flag)
				{
					System.out.println("Successfully Login");
				}
				else
				{
					System.out.println("Incorrect password or username");
				}
				break;
			case 3:
				System.out.println("Thanks...Visit Again...");
				System.exit(0);
			default:
					System.out.println("Invalid Choice");
			}
		}while(ch > 0);
	}
}
