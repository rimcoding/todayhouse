package com.house;

import java.util.List;

import com.house.dao.PhotoDAO;
import com.house.dao.UserDAO;
import com.house.dto.PhotoDTO;
import com.house.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {
	UserDAO userDAO = new UserDAO();
	UserDTO userdto = new UserDTO();
	userdto.setEmail("yog4130@naver.com");
	userdto.setPassword(1111);
	UserDTO dto = userDAO.login(userdto);
	System.out.println(dto);
	PhotoDAO dao = new PhotoDAO();
	PhotoDTO dto2 = new PhotoDTO();
	dao.find(35);
	System.out.println(dto2);
	}
	
}
