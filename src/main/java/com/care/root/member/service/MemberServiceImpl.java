package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;
	
	@Override
	public void join(MemberDTO dto) {
		dao.join(dto);
	}
	@Override
	public String dbIdCheck(String id) {
		String dbId = dao.dbIdCheck(id);
		if(dbId == null) {
			return "회원가입 가능";
		} else {
			return "중복된 아이디입니다";
		}
	}
	@Override
	public String login(MemberDTO dto, Model model) {
		MemberDTO dbDto = dao.login(dto);
		if(dbDto == null) {
			model.addAttribute("message", "아이디가 없습니다.");
			return "/member/loginForm";
		}else if(!dbDto.getPw().equals(dto.getPw())) {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다");
			return "/member/loginForm";
		}else {
			//TODO 메인페이지 수정 예정
			return "main";
		}
	}
}
