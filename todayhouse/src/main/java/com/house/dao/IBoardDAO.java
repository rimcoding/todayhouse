package com.house.dao;

public interface IBoardDAO {
	int save(int user_id, String title, String text);
	void select(String title);
}
