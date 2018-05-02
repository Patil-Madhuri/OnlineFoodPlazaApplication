package com.foodPlaza.Pojo;

public class Cart 
{
	private int cartid;
	private int foodid;
	private double foodprice;
	private String foodname;
	private String custemailid;
	private int quantity;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public double getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getCustemailid() {
		return custemailid;
	}
	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", foodid=" + foodid + ", foodprice=" + foodprice + ", foodname=" + foodname
				+ ", custemailid=" + custemailid + ", quantity=" + quantity + "]";
	}
	
	

}
