package com.foodplaza.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodPlaza.Pojo.Cart;
import com.foodPlaza.Pojo.Order;
import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Cart c = new Cart();
	 CartDaoImpl cdao = new CartDaoImpl();
	 OrderDaoImpl odao=new OrderDaoImpl();
	    boolean flag;
	   
    public CartServlet() 
    {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String cuname = (String)session.getAttribute("cusername");
		String action = request.getParameter("action");
		if(action != null && action.equals("addtocart"))
		{
			int fid = Integer.parseInt(request.getParameter("foodid"));
			c.setFoodid(fid);
			c.setCustemailid(cuname);
			c.setQuantity(1);
			flag = cdao.addTocart(c);
			if(flag)
			{
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("Failed.html");
			}
		}
		else if(action !=null && action.equals("delete"))
		{
			int cid=Integer.parseInt(request.getParameter("cartid"));
			flag=cdao.deletecart(cid);
		if(flag)
		{
			response.sendRedirect("Cartlist.jsp");	
			}else
			{
				response.sendRedirect("Failed.html");
			}
			
			
			
		}else if(action !=null && action.equals("deleteorder"))
		{
			int oid=Integer.parseInt(request.getParameter("orderid"));
			flag=odao.deleteorder(oid);
		if(flag)
		{
			response.sendRedirect("OrderList.jsp");	
			}else
			{
				response.sendRedirect("Failed.html");
			}
		
		
		}else if(action != null && action.equals("showorder"))
		{
			List<Order> olist=odao.showorder();
			session.setAttribute("Orderlist", olist);
			response.sendRedirect("OrderList.jsp");
			
		}
		else if(action != null && action.equals("showcart"))
		{
		List<Cart> clist=cdao.showcart(cuname);	
		session.setAttribute("Cartlist", clist);
		response.sendRedirect("CartList.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		OrderDaoImpl odao = new OrderDaoImpl();
		double totalbill=0;
		String uname =(String)session.getAttribute("cusername");
		String price[] = request.getParameterValues("price");
		String quantity[] = request.getParameterValues("quantity");
		for(int i=0;i<price.length;i++)
		{
			totalbill = totalbill + (Integer.parseInt(quantity[i])*Double.parseDouble(price[i]));
			
		}
		System.out.println(totalbill);
         flag=odao.placeorder(uname, totalbill);
         if(flag)
         {
        	 response.sendRedirect("index.jsp");
         }else
         {
        	 response.sendRedirect("Failed.html");
         }
		
	}

}
