package com.house;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.house.dao.PhotoDAO;
import com.house.dto.PhotoDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/borderService")
public class BorderService<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BorderService() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		PhotoDAO photoDAO = new PhotoDAO();
		
	
			String saveFolder = "C:\\todayhouse\\todayhouse\\todayhouse\\src\\main\\webapp\\images";
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
			System.out.println(result);
		
	}
	
}
