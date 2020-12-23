package com.care.root.sms.dto;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagesRequestDto {
	private String to;
	private String content;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
