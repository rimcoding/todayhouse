package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.house.dto.ReplyDTO;
import com.house.utils.DbHelper;
import com.mysql.cj.protocol.Resultset;

public class ReplyDAO implements IReplyDAO {

	private DbHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ReplyDAO() {
		dbHelper = new DbHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public int reply_save(int userid,int boardid,String content,String nickname) {
		int resultrow = 0;
		String qurey =" INSERT INTO reply(userid,boardid,content,nickname) "
				+ " VALUES "
				+ "	( ? , ? , ? , ? )";
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, boardid);
			pstmt.setString(3, content);
			pstmt.setString(4, nickname);
			resultrow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("replyDao에서 에러 발생");
			e.printStackTrace();
		}
		return resultrow;
	}

	@Override
	public List<ReplyDTO> reply_find(int boardid) {
		
		
		String query = " SELECT * FROM reply "
				+ 	   " where boardid = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardid);
			rs = pstmt.executeQuery();
			List<ReplyDTO> replys = new ArrayList<>();
		while(rs.next()) {
			ReplyDTO dto = new ReplyDTO();
			dto.setId(rs.getInt("id"));
			dto.setUserid(rs.getInt("userid"));
			dto.setBoardid(rs.getInt("boardid"));
			dto.setNickname(rs.getString("nickname"));
			dto.setContent(rs.getString("content"));
			replys.add(dto);
		}
		return replys;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public int delete(int id, int userid) {
		int result = 0;
		String query= " DELETE FROM reply "
				+ 	  " WHERE id = ? AND userid = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setInt(2, userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int update(String content, int userid,int id) {
		int result = 0;
		String query = "  UPDATE reply "
				+ "    	  set content = ? "
				+ "    	  WHERE userid = ? AND id = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setInt(2, userid);
			pstmt.setInt(3, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
