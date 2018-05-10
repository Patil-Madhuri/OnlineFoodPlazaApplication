package com.foodplaza.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.foodplaza.dao.FeedBackDaoImpl;
import com.foodPlaza.Pojo.Customer;
import com.foodPlaza.Pojo.FeedBack;


@WebServlet("/FeedBackServlet")
public class FeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    boolean flag;
    FeedBackDaoImpl fimpl = new FeedBackDaoImpl();
    public FeedBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session =request.getSession();
		String action = request.getParameter("action");
		if(action != null && action.equals("Delete"))
		{
			int id =Integer.parseInt(request.getParameter("fid"));
			flag = fimpl.deleteFeedBack(id);
			if(flag)
			{
				response.sendRedirect("Success.html");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
		}

		else
		{
			List<FeedBack> flist = fimpl.getAllFeedBack();
			session.setAttribute("FeedBackList", flist);
			response.sendRedirect("FeedBackList.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Customer c=new Customer();
		String action = request.getParameter("action");
		FeedBack f=new FeedBack();
		
		if(action !=null && action.equals("feedBack"))
		{
			String customerName=request.getParameter("name");
			String customerEmailId=request.getParameter("email");
			String comments=request.getParameter("comments");

			f.setCustomerName(customerName);
			f.setCustomerEmailId(customerEmailId);
			f.setComments(comments);
			 flag=fimpl.submitfeddback(f);
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


