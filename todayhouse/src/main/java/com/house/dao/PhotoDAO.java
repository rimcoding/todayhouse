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
	public List<PhotoDTO> listfind4() {
		String query = " SELECT *"
				+ " FROM photo_board AS p "
				+ " INNER JOIN user AS u "
				+ " ON p.userId = u.id "
				+ " ORDER BY p.createDate DESC LIMIT 0,5;";
					
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			List<PhotoDTO> boards4 = new ArrayList<>();
			
			while(rs.next()) {
				PhotoDTO dto = new PhotoDTO();
				dto.setId(rs.getInt("p.id"));
				dto.setPhotoImage(rs.getString("p.photoImage"));
				dto.setUserId(rs.getInt("p.userid"));
				dto.setNickname(rs.getString("u.nickname"));
				dto.setContent(rs.getString("content"));
				boards4.add(dto);
			}
			return boards4;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public PhotoDTO find(int id) {
		String query = " SELECT * "
				+ " FROM photo_board AS p "
				+ " INNER JOIN user AS u "
				+ " on p.userId = u.id "
				+ " WHERE p.id = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PhotoDTO dto = new PhotoDTO();
				dto.setId(rs.getInt(rs.getInt("p.id")));
				dto.setPhotoImage(rs.getString("p.photoImage"));
				dto.setContent(rs.getString("p.content"));
				dto.setReadCount(rs.getInt("p.readCount"));
				dto.setUserId(rs.getInt("p.userId"));
				dto.setNickname(rs.getString("u.nickname"));
				return dto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateCount() {
		return 0;
	}

	@Override
	public int delete(int userid,String photoImage) {
		int result = 0;
		String query = " DELETE FROM photo_board "
				+ 	   " where userid = ? AND photoImage = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setString(2, photoImage);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<PhotoDTO> listfind12() {
		String query = " SELECT * "
				+ " FROM photo_board AS p "
				+ " INNER JOIN user AS u "
				+ " ON p.userId = u.id "
				+ " ORDER BY p.createDate DESC LIMIT 0,12; ";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			List<PhotoDTO> boards12 = new ArrayList<>();
			while(rs.next()) {
				PhotoDTO dto = new PhotoDTO();
				dto.setId(rs.getInt("p.id"));
				dto.setPhotoImage(rs.getString("p.photoImage"));
				dto.setUserId(rs.getInt("p.userid"));
				dto.setNickname(rs.getString("u.nickname"));
				dto.setContent(rs.getString("p.content"));
				boards12.add(dto);
			}
			return boards12;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	


}
