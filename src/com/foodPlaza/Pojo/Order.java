package com.foodPlaza.Pojo;

public class Order 
{
	private int orderid;
	private String custemailid;
	private double totalbill;
	private String status;
	private String date;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCustemailid() {
		return custemailid;
	}
	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}
	public double getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", custemailid=" + custemailid + ", totalbill=" + totalbill + ", status="
				+ status + ", date=" + date + "]";
	}
	
	
	
}
