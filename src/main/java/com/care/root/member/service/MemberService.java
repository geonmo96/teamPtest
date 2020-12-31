package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

@Service
public interface MemberService {
	public void join(MemberDTO dto);
	public String dbIdCheck(String id);
	public String login(MemberDTO dto, Model model, HttpServletRequest request);
	public void logout(HttpServletRequest request);
	public void checkEmail(String name, String email, Model model);
	public String checkId(String name, String id, Model model, String method, HttpServletRequest request);
	public void modifyPw(String id, String pw);
	public String send6Num(String m_tel);
	public String dbNameCheck(MemberDTO dto, HttpServletRequest request);
	public void setInfo(HttpServletRequest request, Model model);
	public String checkIdPw(MemberDTO dto);
	public void secession(String id, HttpServletRequest request);
}
