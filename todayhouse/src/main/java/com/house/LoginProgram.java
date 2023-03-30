package com.house;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.house.dao.UserDAO;
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
		System.out.println("login post동작되는지 확인");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		userDAO.login(email, Integer.parseInt(password));
		System.out.println(email);
		System.out.println(password);
	}

}
