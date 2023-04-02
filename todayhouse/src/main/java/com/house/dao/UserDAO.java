package com.house.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.house.dto.UserDTO;
import com.house.utils.DbHelper;

public class UserDAO implements IUserDAO {
	
	private DbHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		dbHelper = new DbHelper();
		conn = dbHelper.getConnection();
	}
	@Override
	public int save(String email,int password, String nickname) {
		int resultrow = 0;
		String query = "  INSERT INTO user(email,password,nickname) "
				+ "    VALUES "
				+ " ( ? , ? , ? ) ";
		System.out.println("사진업로드가 안된다.");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setInt(2, password);
			pstmt.setString(3, nickname);
			resultrow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UserDao에서 에러 발생");
			e.printStackTrace();
		}
		return resultrow;
	}
	@Override
	public UserDTO login(UserDTO dto) {
		
		UserDTO resultUser = null;
		
		String query = " SELECT * FROM user "
				+ "    WHERE email = ? AND password = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,dto.getEmail());
			pstmt.setInt(2,dto.getPassword());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserDTO user = new UserDTO();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				resultUser = user;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultUser;
	}

}
