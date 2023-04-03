package com.house.dto;

public class ReplyDTO {
	private int id;
	private int userid;
	private int boardid;
	private String nickname;
	private String content;
	
	
	@Override
	public String toString() {
		return "ReplyDTO [id=" + id + ", userid=" + userid + ", boardid=" + boardid + ", nickname=" + nickname
				+ ", content=" + content + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
