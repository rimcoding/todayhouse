package com.house;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.house.dao.ReplyDAO;

/**
 * Servlet implementation class ReplyService
 */
@WebServlet("/replyService")
public class ReplyService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReplyDAO replydao;
    public ReplyService() {
    	replydao = new ReplyDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("댓글저장");
	request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("uu");
	String boardId = request.getParameter("boardId");
	String content = request.getParameter("rr");
	System.out.println(content);
	int result = replydao.reply_save(Integer.parseInt(userId),Integer.parseInt(boardId),content);
	System.out.println(result);
	response.sendRedirect("border/replysuccess.jsp");
	}

}
