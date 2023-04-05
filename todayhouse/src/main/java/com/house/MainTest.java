package com.house;

import java.util.List;

import com.house.dao.PhotoDAO;
import com.house.dao.ReplyDAO;
import com.house.dao.UserDAO;
import com.house.dto.PhotoDTO;
import com.house.dto.ReplyDTO;
import com.house.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {
	UserDAO userDAO = new UserDAO();
	UserDTO userdto = new UserDTO();
	PhotoDAO dao = new PhotoDAO();
	ReplyDAO replyDAO = new ReplyDAO();
	List<ReplyDTO> reply = replyDAO.reply_find(1);
	PhotoDTO dto = dao.find(4);
	System.out.println(dto);
	}
	
	
}
