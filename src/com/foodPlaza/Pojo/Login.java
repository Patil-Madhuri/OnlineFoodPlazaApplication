package com.foodPlaza.Pojo;

public class Login
{
	private String un;
	private String pwd;
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Login [un=" + un + ", pwd=" + pwd + "]";
	}
	
	
}
