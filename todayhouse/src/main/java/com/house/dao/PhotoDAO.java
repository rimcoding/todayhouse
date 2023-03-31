package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


}
