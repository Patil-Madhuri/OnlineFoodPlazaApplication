package com.foodplaza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodPlaza.Pojo.Customer;
import com.foodplaza.dao.CustomerDaoImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	boolean flag;
	Customer c = new Customer();
    CustomerDaoImpl cdao = new CustomerDaoImpl();  
   
    public CustomerServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action != null && action.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("custid"));
			flag = cdao.deleteCustomer(id);
			if(flag)
			{
				response.sendRedirect("Success.html");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
		}
		else if(action != null && action.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("custid"));
			c = cdao.getById(id);
			//session = request.getSession();
			session.setAttribute("Customer", c);
			response.sendRedirect("UpdateCust.jsp");
		}
		else
		{
		session = request.getSession();
		List<Customer> clist = cdao.getall();
		//System.out.println(clist);
		session.setAttribute("CustomerList", clist);
		response.sendRedirect("Customerlist.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action != null && action.equals("updatecust"))
		{
			int id = Integer.parseInt(request.getParameter("cid"));
			String cname = request.getParameter("cname");
			String cemail = request.getParameter("cemail");
			//String cpass = request.getParameter("cpass");
			long cphone = Long.parseLong(request.getParameter("cphone"));
			String cadd = request.getParameter("cadd");
			c.setCustid(id);
			c.setCustname(cname);
			c.setCustemail(cemail);
		//	c.setPassword(cpass);
			c.setCustphone(cphone);
			c.setAddress(cadd);
			flag = cdao.updateCustomer(c);
			if(flag)
			{
				response.sendRedirect("Success.html");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
			
			
		}
		else if(action != null && action.equals("addcustomer"))
		{
		//name,email,password, contact no,address
		String cname = request.getParameter("cname");
		String cemail = request.getParameter("cemail");
		String cpass = request.getParameter("cpass");
		long cphone = Long.parseLong(request.getParameter("cphone"));
		String cadd = request.getParameter("cadd");
		c.setCustname(cname);
		c.setCustemail(cemail);
		c.setPassword(cpass);
		c.setCustphone(cphone);
		c.setAddress(cadd);
		flag = cdao.addCustomer(c);
		if(flag)
		{
			response.sendRedirect("Success.html");
		}
		else
		{
			response.sendRedirect("Failed.html");
		}
		
		}	
		
	}

}
