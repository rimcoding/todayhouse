package com.house;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.SslConnectorCiphersTask;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.house.dao.UserDAO;

@WebServlet("/JoinProgram")
public class JoinProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDAO userDAO;
    public JoinProgram() {
    	userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post동작 되는지 확인");
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int result = userDAO.save(email, Integer.parseInt(password), nickname);
		if (result == 1) {
			response.sendRedirect("/login/joinSuccess.jsp");
		}else {
			response.sendRedirect("/login/joinfall.jsp");
		}
	}

}
