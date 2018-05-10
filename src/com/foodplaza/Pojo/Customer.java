package com.foodPlaza.Pojo;

public class Customer
{
	private int custid;
	private String custname;
	private String custemail;
	public String getCustemail() {
		return custemail;
	}
	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}
	private String address;
	private long custphone;
	private String password;
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getCustphone() {
		return custphone;
	}
	public void setCustphone(long custphone) {
		this.custphone = custphone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custemail=" + custemail + ", address="
				+ address + ", custphone=" + custphone + ", password=" + password + "]";
	}
	
	
	
	}
	
	
	
	

