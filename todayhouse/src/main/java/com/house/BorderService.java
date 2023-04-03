package com.house;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.house.dao.PhotoDAO;
import com.house.dao.ReplyDAO;
import com.house.dto.PhotoDTO;
import com.house.dto.ReplyDTO;
import com.house.dto.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/borderService")
public class BorderService<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BorderService() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		PhotoDAO photoDAO = new PhotoDAO();
		ReplyDAO replyDAO = new ReplyDAO();
		if (cmd.equals("index")){
			List<PhotoDTO> boards = photoDAO.listfind4();
			request.setAttribute("boards", boards);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
					
		}else if (cmd.equals("communuty")) {
			List<PhotoDTO> boardss = photoDAO.listfind12();
			request.setAttribute("boards2", boardss);
			RequestDispatcher diss = request.getRequestDispatcher("border/communuty.jsp");
			diss.forward(request, response);
			}else if(cmd.equals("detail")) {
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				PhotoDTO dto = photoDAO.find(id);
				ReplyDTO reply = replyDAO.reply_find(id);
				System.out.println(dto);
				System.out.println(reply);
				request.setAttribute("dto", dto);
				request.setAttribute("reply", reply);
				RequestDispatcher dis = request.getRequestDispatcher("border/detailboard.jsp");
				dis.forward(request, response);
			}
			}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		PhotoDAO photoDAO = new PhotoDAO();
		
			if (cmd.equals("upload")) {
				// saveFolder 이미지 폴더 경로가 맞아야 저장된다.
				String saveFolder = "C:\\Users\\yog41\\Desktop\\todayhouse\\todayhouse\\todayhouse\\src\\main\\webapp\\images";
				String encType = "UTF-8";
				int maxSize = 5 * 1024 * 1024;
			
					MultipartRequest multi = null;
					multi = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());
					Enumeration<E> params = multi.getParameterNames();
					Enumeration files = multi.getFileNames();
					
					String userId = (String)params.nextElement();
					int userId_value = Integer.parseInt(multi.getParameter(userId));
					
					String content = (String) params.nextElement();
					String content_value = multi.getParameter(content);
					
					String photo = (String)files.nextElement();
					String filename = multi.getFilesystemName(photo);
					PhotoDTO dto = new PhotoDTO();
					dto.setUserId(userId_value);
					dto.setPhotoImage(filename);
					dto.setContent(content_value);
					int result = photoDAO.save(dto);
					if (result == 0) {
						response.sendRedirect("border/writenull.jsp");
					}else {
						response.sendRedirect("index2.jsp");
					}
				
			}else if (cmd.equals("uploadForm")) {
				UserDTO principal = (UserDTO)session.getAttribute("principal");
				if (principal != null) {
					response.sendRedirect("border/uploadboadrd.jsp");
				}else {
					response.sendRedirect("border/writefall.jsp");
				}
			}else if (cmd.equals("coummunuty")) {
				UserDTO principal = (UserDTO)session.getAttribute("principal");
				if (principal != null) {
					response.sendRedirect("border/communuty2.jsp");
				}else {
					response.sendRedirect("border/writefall.jsp");
				}
			}
			
		
	}
}
