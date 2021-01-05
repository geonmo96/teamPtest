package com.care.root.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.care.root.board.dto.BoardDTO;

@Repository
public interface BoardDAO {
	
	
	@Select("select b.* from (select rownum rn, a.* from (select * from board order by write_no desc)a)b where rn between #{start} and #{end}")
	public ArrayList<BoardDTO> listView(@Param("start") int start, @Param("end") int end);
	@Select("select * from board where write_no = #{write_no}")
	public BoardDTO contentView(String write_no);
	@Select("select count(*) from board")
	public int totalContent();
	
	@Update("update board set hit = hit + 1 where write_no = #{write_no}")
	public void hit(String write_no);
	@Update("update board set title = #{title}, content = #{content} where write_no = #{write_no}")
	public void modify(BoardDTO boardDto);
	
	@Delete("delete from board where write_no = #{write_no}")
	public void delete(String write_no);
	
	@Insert("insert into board(write_no, title, content) values(board_seq.nextval, #{title}, #{content})")
	public void write(BoardDTO boardDto);
}
