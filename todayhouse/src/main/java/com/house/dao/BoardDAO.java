package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.house.dto.BoardDTO;
import com.house.utils.DbHelper;

public class BoardDAO implements IBoardDAO {

	private DbHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO() {
		dbHelper = new DbHelper();
		conn = dbHelper.getConnection();
	}
	@Override
	public int save(int user_id, String title, String text) {
		int resultRow =0 ;
		String query = "  ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, user_id);
			pstmt.setString(2, title);
			pstmt.setString(3, text);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultRow;
		
	}
	@Override
	public void select(String title) {
		
		String query = "  ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setUser_id(rs.getInt("user_id"));
				dto.setTitle(rs.getString("title"));
				dto.setText(rs.getString("text"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
