package com.house.dao;

import java.util.List;

import com.house.dto.PhotoDTO;

public interface IPhotoDAO {
	int save(PhotoDTO dto);
	List<PhotoDTO> listfind();
	PhotoDTO find(int id);
	int updateCount();
	int delete();
}
