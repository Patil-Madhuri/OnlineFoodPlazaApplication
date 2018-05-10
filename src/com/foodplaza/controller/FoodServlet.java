package com.foodplaza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodPlaza.Pojo.Food;
import com.foodplaza.dao.FoodDaoImpl;

/**
 * Servlet implementation class FoodServlet
 */

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	boolean flag;
	Food f = new Food();
	FoodDaoImpl fdao = new FoodDaoImpl();
	
    public FoodServlet() 
    {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		//System.out.println(action);
		if(action != null && action.equals("delete"))
		{
			int fid= Integer.parseInt(request.getParameter("foodid"));
			//System.out.println(fid);
			flag = fdao.deleteFood(fid);
			//System.out.println(flag);
			if(flag)
			{
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
		}
		else if(action != null && action.equals("update"))
		{
			int fid= Integer.parseInt(request.getParameter("foodid"));
			f =  fdao.getById(fid);
			//System.out.println(f);
			session = request.getSession();
			session.setAttribute("Food", f);
			response.sendRedirect("UpdateFood.jsp");
			
		}
		else 
		{
		
		List<Food> flist = fdao.getall();
		//System.out.println(flist);
		session.setAttribute("FoodList", flist);
		response.sendRedirect("Foodlist.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action != null && action.equals("updatefood"))
		{
			int fid = Integer.parseInt(request.getParameter("fid"));
			String fname= request.getParameter("fname");
			double fprice = Double.parseDouble(request.getParameter("fprice"));
			String fcat = request.getParameter("fcat");
			//f.setFood_id(fid);
			f.setFood_name(fname);
			f.setFood_price(fprice);
			f.setFood_category(fcat);
			flag = fdao.updateFood(f);
			if(flag)
			{
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
		}
		else if(action != null && action.equals("addfood"))
		{
		String fname = request.getParameter("fname");
		double fprice = Double.parseDouble(request.getParameter("fprice"));
		String fcat = request.getParameter("fcat");
		//System.out.println(fname + " " +fprice +" "+ fcat);
		f.setFood_name(fname);
		f.setFood_price(fprice);
		f.setFood_category(fcat);
		flag = fdao.addFood(f);
		if(flag)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("Failed.html");
		}
		}
	}

}
