package com.house;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.house.dao.UserDAO;
import com.house.dto.UserDTO;
@WebServlet("/LoginProgram")
public class LoginProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    public LoginProgram() {
    	userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		System.out.println("login post동작되는지 확인");
		if (cmd.equals("login")) {
			request.setCharacterEncoding("UTF-8");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserDTO dto = new UserDTO();
			dto.setEmail(email);
			dto.setPassword(Integer.parseInt(password));
			UserDTO user = userDAO.login(dto);
			System.out.println(user);	
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("principal", user);
				session.setAttribute("nick", user.getNickname());
				response.sendRedirect("/login/loginSuccess.jsp");
			}else if(user == null) {
				response.sendRedirect("/login/loginfall.jsp");
			}
		}else if(cmd.equals("logout")){
			System.out.println("1111111111");
			 HttpSession session = request.getSession();
			 session.invalidate();
			 response.sendRedirect("/index2.jsp");
		}
		
		
	}

}
