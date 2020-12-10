package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;

public interface KakaoService {
	public void login(String code, HttpServletRequest request);
}
