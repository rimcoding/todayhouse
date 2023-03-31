package com.house.dto;

import java.security.Timestamp;

public class PhotoDTO {
	private int id;
	private int userId;
	private String photoImage;
	private String content;
	private int readCount;
	private int favorite;
	private Timestamp createDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhotoImage() {
		return photoImage;
	}
	public void setPhotoImage(String photoImage) {
		this.photoImage = photoImage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public PhotoDTO(int userId, String photoImage, String content) {
		this.userId = userId;
		this.photoImage = photoImage;
		this.content = content;
	}
	
	public PhotoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
}
