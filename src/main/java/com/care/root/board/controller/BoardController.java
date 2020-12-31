package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.board.service.BoardServiceImpl;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardServiceImpl boardService;
	
	@RequestMapping("listView")
	public String listView(Model model) {
		boardService.listView(model);
		return "/board/listView";
	}
	
	@RequestMapping("contentView")
	public String contentView(Model model, @RequestParam("write_no") String write_no) {
		boardService.contentView(model, write_no);
		return "/board/contentView";
	}
}
