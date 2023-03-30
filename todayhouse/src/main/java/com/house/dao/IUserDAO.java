package com.house.dao;

import com.house.dto.UserDTO;

public interface IUserDAO {
	
	int save(String email,int password, String nickname);
	void login(String email, int password);
}
