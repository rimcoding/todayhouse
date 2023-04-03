package com.house.dao;

import com.house.dto.ReplyDTO;

public interface IReplyDAO {
	int reply_save(int userid,int boardid,String content,String nickname);
	ReplyDTO reply_find(int boardid);
}
