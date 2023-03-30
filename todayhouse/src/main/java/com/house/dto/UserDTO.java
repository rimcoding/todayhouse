package com.house.dto;

public class UserDTO {
	
	private String email;
	private int password;
	private String nickname;
	
	public UserDTO() {
	}
	
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + ", nickname=" + nickname + "]";
	}

	public UserDTO(String email, int password) {
		this.email = email;
		this.password = password;
	}

	public UserDTO(String email, int password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
