package com.care.root.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardServiceImpl;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardServiceImpl boardService;
	
	@RequestMapping("listView")
	public String listView(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		boardService.listView(model, page);
		return "/board/listView";
	}
	
	@RequestMapping("contentView")
	public String contentView(Model model, @RequestParam("write_no") String write_no) {
		boardService.contentView(model, write_no);
		return "/board/contentView";
	}
	
	@RequestMapping("modifyForm")
	public String modifyForm(Model model, @RequestParam("write_no") String write_no) {
		boardService.modifyForm(model, write_no);
		return "/board/modifyForm";
	}
	@PostMapping("modify")
	public String modify(Model model, BoardDTO boardDto) {
		boardService.modify(model, boardDto);
		return "redirect:contentView";
	}
	@RequestMapping("delete")
	public String delete(@RequestParam("write_no") String write_no) {
		boardService.delete(write_no);
		return "redirect:listView";
	}
	
	@RequestMapping("writeForm")
	public String writeForm() {
		return "/board/writeForm";
	}
	@PostMapping("write")
	public String write(Model model, BoardDTO boardDto) {
		boardService.write(boardDto);
		return "redirect:listView";
	}
}
