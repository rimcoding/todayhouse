package com.house.dao;

import com.house.dto.UserDTO;

public interface IUserDAO {
	
	int save(String email,int password, String nickname);
	UserDTO login(UserDTO dto);
}
