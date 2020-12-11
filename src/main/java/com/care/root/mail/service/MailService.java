package com.care.root.mail.service;

public interface MailService{
	public void sendMail(String to, String subject, String body);
	public String sendCode(String email);
	public void sendId(String email);
}
