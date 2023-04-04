package com.house.dao;

import java.util.List;

import com.house.dto.ReplyDTO;

public interface IReplyDAO {
	int reply_save(int userid,int boardid,String content,String nickname);
	List<ReplyDTO> reply_find(int boardid);
	int delete(int id,int userid);
	int update(String content, int userid,int id);
}
