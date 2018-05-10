package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.foodPlaza.Pojo.FeedBack;
import com.foodplaza.utility.DButility;

public class FeedBackDaoImpl implements FeedbackDao 
{
	Connection con;
	PreparedStatement ps;

	@Override
	public boolean submitfeddback(FeedBack f)
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("insert into feedBack_20479(name, email, feedback) values (?,?,?)");
			ps.setString(1, f.getCustomerName());
			ps.setString(2, f.getCustomerEmailId());
			ps.setString(3, f.getComments());
			int x=ps.executeUpdate();
			if(x>0){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<FeedBack> getAllFeedBack()
	{
		List<FeedBack> flist = new LinkedList<>();
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("select * from feedback_20479");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				FeedBack f=new FeedBack();
				f.setFid(rs.getInt("id"));
				f.setCustomerEmailId(rs.getString("email"));
				f.setCustomerName(rs.getString("name"));				
				f.setComments(rs.getString("feedback"));
				
				flist.add(f);
			}
			return flist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flist;
	}

	@Override
	public boolean deleteFeedBack(int fid)
	{
		con = DButility.getconnection();
		try {
			ps = con.prepareStatement("delete from feedBack_20479 where id=?");
			ps.setInt(1, fid);
			
			int x=ps.executeUpdate();
			
			if(x>0){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
