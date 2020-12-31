package com.care.root.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.care.root.board.dto.BoardDTO;

@Repository
public interface BoardDAO {
	
	@Select("select * from board")
	public ArrayList<BoardDTO> listView();
	@Select("select * from board where write_no = #{write_no}")
	public BoardDTO contentView(String write_no);
	
	@Update("update board set hit = hit + 1 where write_no = #{write_no}")
	public void hit(String write_no);
}
