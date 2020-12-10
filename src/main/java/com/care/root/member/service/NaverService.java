package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;

public interface NaverService {
	public void generateState(HttpServletRequest request);
	public void login(String code, String state, HttpServletRequest request);
}
