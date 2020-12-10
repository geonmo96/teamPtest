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
import com.care.root.member.service.KakaoService;
import com.care.root.member.service.MemberService;
import com.care.root.member.service.NaverService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberService ms;
	@Autowired KakaoService ks;
	@Autowired NaverService ns;
	
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
		return "redirect:" + path; // 성공 main(임시), 실패 (loginForm)
	}
	@RequestMapping("loginKakao")
	public String loginKakao(@RequestParam("code") String code, HttpServletRequest request) {
//		System.out.println(code);
		ks.login(code, request);
		return "redirect:main";
	}
	@RequestMapping(value = "loginNaver")
	public String loginNaver(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletRequest request) {
		ns.login(code, state, request);
		return "redirect:main";
	}
	@RequestMapping(value = "createNaverState")
	public String createNaverState(HttpServletRequest request) {
		ns.generateState(request);
		return "/member/createNaverState";
	}
	@RequestMapping(value = "main" , produces="application/text;charset=utf-8")
	public String main() {
		return "/main";
	}
}
