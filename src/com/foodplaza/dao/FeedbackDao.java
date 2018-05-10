package com.foodplaza.dao;

import java.util.List;

import com.foodPlaza.Pojo.FeedBack;

public interface FeedbackDao 
{
	boolean submitfeddback(FeedBack f);
	List<FeedBack> getAllFeedBack();
	boolean deleteFeedBack(int fid);
}
