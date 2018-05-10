package com.foodplaza.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String type= request.getParameter("type");
		//System.out.println(type);
		String un = request.getParameter("email");
		//System.out.println(un);
		String pwd = request.getParameter("pass");
		//System.out.println(pwd);
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		String cpwd = request.getParameter("cpwd");
		RequestDispatcher rd;
		 response.setContentType("text/html");
	if(action != null && action.equals("login"))	
	{
		if(type != null && type.equals("customer"))
		{
			flag = ldao.loginCust(un, pwd);
			//System.out.println(flag);
			if(flag)
			{
				session.setAttribute("cusername", un);
				//response.sendRedirect("index.jsp");
				// out.println("Login Successfully");
				  rd=request.getRequestDispatcher("index.jsp");
				  //request.setAttribute("msg", "Login Sucessfully");
				  rd.forward(request, response);
			}
			else
			{
				//out.println("Incorrect username and password");
				//out.println("<b>Incorrect User Name or Password</b>");
				  rd=request.getRequestDispatcher("Login.jsp");
				  request.setAttribute("msg", "<b><center>Incorrect username and password</b></center>");
				  rd.forward(request, response);
			}
		}
		else if(type != null && type.equals("admin"))
		{
			flag = ldao.loginAdmin(un, pwd);
			System.out.println(flag);
			if(flag)
			{
				session.setAttribute("ausername", un);
				//response.sendRedirect("index.jsp");
				  rd=request.getRequestDispatcher("index.jsp");
				  //request.setAttribute("msg", "Login Sucessfully");
				  rd.forward(request, response);
			}
			else
			{
				//out.println("Incorrect username and password");
				out.println("Incorrect User Name or Password");
				  rd=request.getRequestDispatcher("Login.jsp");
				  request.setAttribute("msg", "<b><center>Incorrect username and password</b></center>");
				  rd.forward(request, response);
			}
		}
	}
	else if(action != null && action.equals("changepwd"))
		{
			
			
			if(type != null && type.equals("customer"))
			{
				String cname= (String)session.getAttribute("cusername");
				System.out.println(type +" "+ cname + " " + oldpwd +" "+ newpwd);
				if(cpwd.equals(newpwd))
				{
				flag = ldao.updatePwdCust(cname, oldpwd, newpwd);
				System.out.println(flag);
				if(flag)
				{					
					rd = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "<b><center>Password changed successfully</b></center>");
					rd.forward(request, response);
				}
				}
				else
				{
					rd = request.getRequestDispatcher("ChangePassword.jsp");
					request.setAttribute("msg", "<b><center>Your password didn't matched</b></center>");
					rd.forward(request, response);
				}
			}
			else if(type != null && type.equals("admin"))
			{
				String aname = (String)session.getAttribute("ausername");
				if(cpwd.equals(newpwd))
				{
					flag = ldao.updatePwdAdmin(aname, oldpwd, newpwd);
					if(flag)
					{
					System.out.println(flag);					
					rd = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "<b><center>Password changed successfully</b></center>");
					rd.forward(request, response);			
					}
				}	
				else
				{
					rd = request.getRequestDispatcher("ChangePassword.jsp");
					request.setAttribute("msg", "<b><center>Your password didn't matched</b></center>");
					rd.forward(request, response);
				}
			}
		}
		
	}

}
