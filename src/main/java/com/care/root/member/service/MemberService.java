package com.care.root.member.service;

import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;

@Service
public interface MemberService {
	public void join(MemberDTO dto);
	public String dbIdCheck(String id);
}
