package com.care.root.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.board.dao.BoardDAO;
import com.care.root.board.dto.BoardDTO;

@Service
public class BoardServiceImpl {
	@Autowired BoardDAO boardDao;
	
	public void listView(Model model) {
		ArrayList<BoardDTO> list = boardDao.listView();
		model.addAttribute("list", list);
	}
	
	public void contentView(Model model, String write_no) {
		boardDao.hit(write_no);
		BoardDTO boardDto = boardDao.contentView(write_no);
		model.addAttribute("boardDto", boardDto);
	}
}
