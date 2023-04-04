package com.house;

import java.io.IOException;
import java.io.PrintWriter;

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
	//System.out.println("댓글저장");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String cmd =request.getParameter("cmd");	
	if (cmd.equals("replysave")) {
		String userId = request.getParameter("userInfo");
		String boardId = request.getParameter("boardId");
		String content = request.getParameter("contentbox");
		String nickname = request.getParameter("nick");
		if (!content.equals("")) {
			 int result = replydao.reply_save(Integer.parseInt(userId),Integer.parseInt(boardId),content,nickname);		
			if (result == 1) {
				response.sendRedirect("border/replysuccess.jsp");			
			}else {
				response.sendRedirect("border/replyfall.jsp");		
			}
		}else {
			response.sendRedirect("border/replyfall.jsp");		
		}
	}
	else if(cmd.equals("replydelete")) {
		request.setCharacterEncoding("UTF-8");
		 String userId = request.getParameter("userInfo");
		 String replyId = request.getParameter("replyId");
		 int result = replydao.delete(Integer.parseInt(replyId),Integer.parseInt(userId));
		 if (result == 0) {
			 response.setContentType("text/html; charset=UTF-8");                 
			 PrintWriter writer = response.getWriter();                 
			 writer.println("<script>alert('본인이 작성한거 맞으신가요?.'); location.href='/border/communuty2.jsp';</script>");                 
			 writer.close();
		}else {
			 response.setContentType("text/html; charset=UTF-8");                 
			 PrintWriter writer = response.getWriter();                 
			 writer.println("<script>alert('댓글이 삭제되었습니다.'); location.href='/border/communuty2.jsp';</script>");                 
			 writer.close();
		}
	}else if (cmd.equals("update")) {
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("content");
		String userid = request.getParameter("userid");
		String id = request.getParameter("id");
		System.out.println(content);
		System.out.println(userid);
		System.out.println(id);
		int result = replydao.update(content,Integer.parseInt(userid),Integer.parseInt(id));
		System.out.println(result);
		if (result==0) {
			response.setContentType("text/html; charset=UTF-8");                 
			 PrintWriter writer = response.getWriter();                 
			 writer.println("<script>alert('본인이 작성한거 맞으신가요?.'); location.href='/border/communuty2.jsp';</script>");                 
			 writer.close();
		}else {
			response.setContentType("text/html; charset=UTF-8");                 
			 PrintWriter writer = response.getWriter();                 
			 writer.println("<script>alert('댓글이 수정되었습니다.'); location.href='/border/communuty2.jsp';</script>");                 
			 writer.close();
		}
	}
	
	}
}
