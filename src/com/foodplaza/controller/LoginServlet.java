package com.foodplaza.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.LoginDaoImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    boolean flag;
    LoginDaoImpl ldao = new LoginDaoImpl();
    public LoginServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String type= request.getParameter("type");
		System.out.println(type);
		String un = request.getParameter("email");
		System.out.println(un);
		String pwd = request.getParameter("pass");
		System.out.println(pwd);
		
		if(type != null && type.equals("customer"))
		{
			flag = ldao.loginCust(un, pwd);
			System.out.println(flag);
			if(flag)
			{
				out.println("Successfully Login");
			}
			else
			{
				out.println("Incorrect username and password");
			}
		}
		else if(type != null && type.equals("admin"))
		{
			flag = ldao.loginAdmin(un, pwd);
			System.out.println(flag);
			if(flag)
			{
				out.println("Successfully Login");
			}
			else
			{
				out.println("Incorrect username and password");
			}
		}
	}

}
