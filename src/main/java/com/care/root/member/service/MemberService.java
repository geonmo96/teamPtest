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
}
