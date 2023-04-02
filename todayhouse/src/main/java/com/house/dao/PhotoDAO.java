package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.house.dto.PhotoDTO;
import com.house.utils.DbHelper;

public class PhotoDAO implements IPhotoDAO {

	private DbHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public PhotoDAO() {
		dbHelper = new DbHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public int save(PhotoDTO dto) {
		int resultrow = 0;
		String query = " INSERT INTO photo_board(userId,photoImage,content,createDate) "
				+ " VALUES "
				+ " (?,?,?,now()) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getPhotoImage());
			pstmt.setString(3, dto.getContent());
			resultrow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultrow;
	}

	@Override
	public List<PhotoDTO> listfind() {
		String query = " SELECT *"
				+ " FROM photo_board AS p "
				+ " INNER JOIN user AS u "
				+ " ON p.userId = u.id "
				+ " ORDER BY p.createDate DESC LIMIT 0,4;";
					
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			List<PhotoDTO> boards = new ArrayList<>();
			
			while(rs.next()) {
				PhotoDTO dto = new PhotoDTO();
				dto.setId(rs.getInt("p.id"));
				dto.setPhotoImage(rs.getString("p.photoImage"));
				dto.setUserId(rs.getInt("userid"));
				boards.add(dto);
			}
			return boards;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
