package com.house.dao;

public interface IReplyDAO {
	int reply_save(int userid,int boardid,String content);
	
}
