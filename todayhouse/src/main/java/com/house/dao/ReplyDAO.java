package com.house.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.house.utils.DbHelper;
import com.mysql.cj.protocol.Resultset;

public class ReplyDAO implements IReplyDAO {

	private DbHelper dbHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private Resultset rs;
	
	public ReplyDAO() {
		dbHelper = new DbHelper();
		conn = dbHelper.getConnection();
	}
	
	@Override
	public int reply_save(int userid,int boardid,String content) {
		int resultrow = 0;
		String qurey =" INSERT INTO reply(userid,boardid,content) "
				+ " VALUES "
				+ "	( ? , ? , ? )";
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, boardid);
			pstmt.setString(3, content);
			resultrow = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("replyDao에서 에러 발생");
			e.printStackTrace();
		}
		return resultrow;
	}

}
