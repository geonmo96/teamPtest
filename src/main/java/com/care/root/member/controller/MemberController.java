package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping("signupForm")
	public String signupForm() {
		return "/member/signupForm";
	}
	@PostMapping("signup")
	public String signup(MemberDTO dto) {
		ms.join(dto);
		return "/member/loginForm";
	}
	@RequestMapping(value="dbIdCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String dbIdCheck(@RequestParam("id") String id) {
		return ms.dbIdCheck(id);
	}
	@RequestMapping("loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	@PostMapping("login")
	public String login(MemberDTO dto, Model model, HttpServletRequest request) {
		String path = ms.login(dto, model, request);
		return "redirect:" + path;
	}
}
