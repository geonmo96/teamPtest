package com.care.root.mail.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.care.root.member.dao.MemberDAO;

@Service
public class MailServiceImpl implements MailService{
	@Autowired JavaMailSender jms;
	@Autowired MemberDAO dao;
	
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = jms.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(body, true);
			jms.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String sendCode(String email) {
		String code = rand();
		String body = "<h2>안녕하세요</h2>"
				+ "<h3>이메일을 인증하시려면 다음 코드를 입력해주세요</h3>"
				+ "<h4>" + code +"</h4>";
		sendMail(email, "이메일 인증 코드 전송합니다", body);
		return code;
	}
	@Override
	public void sendId(String email) {
		String id = dao.selectIdToEmail(email);
		String body = "<h2>안녕하세요</h2>"
				+ "고객님의 아이디는 " + id + "입니다.";
		sendMail(email, "고객님의 아이디를 전송합니다", body);
	}
	private String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length() != 20) {
			num = ran.nextInt(75) + 48; // 0-74 + 78 (숫자, 소문자, 대문자 범위)
			if((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				str += (char)num;
			} else {
				continue;
			}
		}
		return str;
	}
}
