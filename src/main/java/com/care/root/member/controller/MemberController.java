package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.mail.service.MailService;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.KakaoService;
import com.care.root.member.service.MemberService;
import com.care.root.member.service.NaverService;
import com.care.root.member.service.NaverSmsServiceImpl;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberService ms;
	@Autowired KakaoService ks;
	@Autowired NaverService ns;
	@Autowired MailService mails;
	@Autowired NaverSmsServiceImpl nss;
	
	@PostMapping(value = "sendSms", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String sendSms(@RequestParam("m_tel") String m_tel) {
		return ms.send6Num(m_tel);
	}
	@RequestMapping("join")
	public String join() {
		return "/member/join";
	}
	@RequestMapping("signupForm")
	public String signupForm(@RequestParam("member_code") String member_code, Model model) {
		model.addAttribute("member_code", member_code);
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
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		ms.logout(request);
		return "redirect:main";
	}
	@RequestMapping("findIdEmail")
	public String findId() {
		return "/member/findIdEmail";
	}
	@PostMapping("idEmailCheck")
	public String findIdToEmail(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
		ms.checkEmail(name, email, model);
		return "/member/emailCodeForm";
	}
	@RequestMapping("sendId")
	public String sendId(@RequestParam("email") String email) {
		mails.sendId(email);
		return "redirect:main";
	}
	@RequestMapping("findPwEmail")
	public String findPw() {
		return "/member/findPwEmail";
	}
	@RequestMapping("pwEmailCheck")
	public String findPwToEmail(@RequestParam("name") String name, @RequestParam("id") String id, Model model, HttpServletRequest request) {
		ms.checkId(name, id, model, "email", request);
		return "/member/emailCodeForm";
	}
	@PostMapping("modifyPwForm")
	public String modifyPwForm(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "/member/modifyPwForm";
	}
	@PostMapping("modifyPw")
	public String modifyPw(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		ms.modifyPw(id, pw);
		return "redirect:main";
	}
	@PostMapping(value = "dbNameCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String dbNameCheck(MemberDTO dto, HttpServletRequest request) {
//		System.out.println(dto.getName());
		return ms.dbNameCheck(dto, request);
	}
	@RequestMapping("findIdTel")
	public String findIdTel() {
		return "/member/findIdTel";
	}
	@PostMapping("idAuthCheck")
	public String idAuthCheck(@RequestParam("m_tel") String m_tel, Model model) {
		model.addAttribute("authCode", ms.send6Num(m_tel));
		model.addAttribute("find", "id");
		return "/member/telCodeForm";
	}
	@RequestMapping("idView")
	public String idView() {
		return "/member/idView";
	}
	@RequestMapping("findPwTel")
	public String findPwTel() {
		return "/member/findPwTel";
	}
	@PostMapping(value = "findPwTelCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String findPwTelCheck(@RequestParam("name") String name, @RequestParam("id") String id, Model model, HttpServletRequest request) {
		return ms.checkId(name, id, model, "tel", request);
		
	}
	@PostMapping("telCodeForm")
	public String telCodeForm(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("find", "pw");
		return "/member/telCodeForm";
	}
	@RequestMapping("myInfo")
	public String myInfo(HttpServletRequest request, Model model) {
		ms.setInfo(request, model);
		return "/member/myInfo";
	}
	@RequestMapping("inputPw")
	public String inputPw(@RequestParam("message") String message, Model model) {
		model.addAttribute("message", message);
		return "/member/inputPw";
	}
	@PostMapping(value = "checkIdPw", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String checkIdPw(MemberDTO dto) {
		return ms.checkIdPw(dto);
	}
	@RequestMapping("secession")
	public String secession(@RequestParam("id") String id, HttpServletRequest request) {
		ms.secession(id, request);
		return "redirect:main";
	}
	@RequestMapping("signupSelect")
	public String signupSelect() {
		return "/member/signupSelect";
	}
	@RequestMapping("joinSeller")
	public String joinSeller() {
		return "/member/joinSeller";
	}
}
