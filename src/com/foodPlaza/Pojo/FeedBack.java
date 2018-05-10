package com.foodPlaza.Pojo;

public class FeedBack {
	
	private int fid;
	private String customerName;
	private String customerEmailId;
	private String comments;
	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "FeedBack [fid=" + fid + ", customerName=" + customerName + ", customerEmailId=" + customerEmailId
				+ ", comments=" + comments + "]";
	}
	
	
	

}
