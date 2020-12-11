package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.mail.service.MailService;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDAO dao;
	@Autowired MailService ms;
	
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
	public String login(MemberDTO dto, Model model, HttpServletRequest request) {
		MemberDTO dbDto = dao.login(dto);
		if(dbDto == null) {
			model.addAttribute("message", "아이디가 없습니다.");
			return "/member/loginForm";
		}else if(!dbDto.getPw().equals(dto.getPw())) {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다");
			return "/member/loginForm";
		}else {
			//TODO 메인페이지 수정 예정
			HttpSession session = request.getSession();
			session.setAttribute("USER", dbDto.getId());
			return "main";
		}
	}
	@Override
	public void logout(HttpServletRequest request) {
		HttpSession session = (HttpSession) request.getSession();
		session.removeAttribute("USER");
	}
	@Override
	public void checkEmail(String name, String email, Model model) {
		String dbName = null;
		dbName = dao.selectNameToEmail(email);
		if(dbName == null) {
			model.addAttribute("message", "입력하신 이메일은 없는 이메일입니다");
			model.addAttribute("code", 0);
		} else if(!dbName.equals(name)) {
			model.addAttribute("message", "이메일과 이름이 일치하지 않습니다");
			model.addAttribute("code", 0);
		} else {
			model.addAttribute("message", "메일이 전송되었습니다");
			model.addAttribute("code", ms.sendCode(email));
			model.addAttribute("email", email);
		}
		
	}
}
