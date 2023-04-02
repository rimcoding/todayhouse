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
import com.house.dto.PhotoDTO;
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
		if (cmd.equals("index")){
			List<PhotoDTO> boards = photoDAO.listfind();
			request.setAttribute("boards", boards);
			
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글쓰기");
		
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		PhotoDAO photoDAO = new PhotoDAO();
		
			if (cmd.equals("upload")) {
				// saveFolder 이미지 폴더 경로가 맞아야 저장된다.
				String saveFolder = "C:\\Users\\yog41\\OneDrive\\Desktop\\project\\todayhouse\\todayhouse\\src\\main\\webapp\\images";
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
				System.out.println("111111111");
				if (principal != null) {
					response.sendRedirect("border/uploadboadrd.jsp");
				}else {
					response.sendRedirect("border/writefall.jsp");
				}
			}
			
		
	}
}
