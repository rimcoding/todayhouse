package com.house.dao;

import com.house.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {
	UserDAO userDAO = new UserDAO();
	userDAO.login("yog4130@gmail", 32423);
	UserDTO userdto = new UserDTO();
	System.out.println(userdto);
}
	
}
